package controllers;
import models.Employee;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import views.html.home.*;
import views.html.home.index;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;
public class EmployeeController extends Controller {
    @Inject
    FormFactory formFactory;
    // editing employee record
    public Result edit(Integer id){
        Employee employee=Employee.find.byId(id);
        if (employee==null){
         return notFound("book not found");
        }
        Form<Employee> employeeForm=formFactory.form(Employee.class).fill(employee);
        return ok(edit.render(employeeForm));
    }
    // updating employee record
    public Result update(){
        //Form<Employee> employeeForm=formFactory.form(Employee.class).bindFromRequest();
        Employee employee=formFactory.form(Employee.class).bindFromRequest().get();
        Employee oldEmployee =Employee.find.byId(employee.id);
        if (oldEmployee == null){
            return notFound("Book Not Found");
        }
        oldEmployee.name=employee.name;
        oldEmployee.designation=employee.designation;
        oldEmployee.salary=employee.salary;
        oldEmployee.update();
        return redirect(routes.EmployeeController.index());
    }
    // creating new employee record
    public Result create(){
        Form<Employee> employeeForm=formFactory.form(Employee.class);
        return ok(create.render(employeeForm));
    }
    // saving new employee record
    public Result save(){
        Form<Employee> employeeForm=formFactory.form(Employee.class).bindFromRequest();
        Employee employee=employeeForm.get();
        employee.save();
        return redirect(routes.EmployeeController.index());
    }
    public Result index(){
        List<Employee> employees=Employee.find.all();
        return ok(index.render(employees));
    }

    // deleting employee record
    public Result delete(Integer id){
        Employee employee=Employee.find.byId(id);
        if (employee==null){
            return notFound("employee not found");
        }
        employee.delete();
        return redirect(routes.EmployeeController.index());
    }
    // diplaying employee details
    public Result display(Integer id){
        Employee employee=Employee.find.byId(id);
        if (employee==null){
            return notFound("book not found");
        }
        return ok(display.render(employee));
    }
}
