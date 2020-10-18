package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import play.data.validation.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void sayHello(@Required String userName) {
        if (validation.hasErrors()) {
            flash.error("no name found!");
            index();
        }
        render(userName);
    }
    
    public static void login(@Required String userName, @Required String password) {
        if (validation.hasErrors()) {
            flash.error("Fix user credentials");
            index();
        }
        System.out.println("controllers.Application.login() " + userName + " " + password);
        //insert imto auth table
        //render the next page with the username
        showContacts(userName);
    }
    
    public static void showContacts(String userName) {
        
        //fetch all contacts for current user
        render(userName);
    }
    
    public static void addContact(@Required String userName, @Required String birthday) {
        if (validation.hasErrors()) {
            flash.error("Fix user credentials");
            index();
        }
        //insert birthday into respective table
        //insert contact into respective table
    }

}