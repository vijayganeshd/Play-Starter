package models;
import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


import java.util.*;


@Entity
public class Employee extends Model{
    @Id
    public Integer id;
    public String name;
    public String designation;
    public Double salary;


    public static Finder<Integer,Employee> find=new Finder<>(Employee.class);
}


