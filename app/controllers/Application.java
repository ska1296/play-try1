package controllers;

import dao.UserDAO;
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
        
        UserDAO userDao = new UserDAO();
        User user = userDao.findUser(userName);
        if (user == null || !user.getPassword().equals(password)) {
            flash.error("Fix user credentials");
            index();
        }
        //insert imto auth table
        //render the next page with the username
        
        addContacts(userName);
    }
    
    public static void addContacts(String userName) {
        
        String id = params.get("id");
        String date = params.get("date");
        //fetch all contacts for current user
        render(userName);
        
    }

}