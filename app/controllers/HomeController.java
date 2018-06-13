package controllers;
import play.mvc.*;
import views.html.home.*;
import views.html.*;
import views.html.home.home;

public class HomeController extends Controller {

    public Result index(String user,String company) {

        return ok(home.render(user,company));
    }
}











