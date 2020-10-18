package controllers;

import dao.ContactsDAO;
import dao.UserDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import play.*;
import play.mvc.*;

import models.*;
import org.apache.commons.mail.SimpleEmail;

import play.data.validation.*;
import play.libs.Mail;

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
    
    public static void login(@Required String userName, @Required String password) throws ParseException {
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
        
        addContacts(userName, true);
    }
    
    public static void addContacts(String userName, boolean dos) throws ParseException {
        
        if (!dos) {
            String contactName = params.get("id");
            
            if (contactName == null || contactName.isEmpty() || params.get("date").isEmpty()) {
                flash.error("Fix user input");
                addContacts(userName, false);
            }

            
            String date_s =  params.get("date") + " 00:00:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            int hours = Integer.parseInt(params.get("hours"));
            Contacts contact = new Contacts();
            contact.setUsername(userName);
            contact.setContactName(contactName);
            ContactsDAO contactsDAO = new ContactsDAO();
            Birthday bDay = new Birthday();
            bDay.setUserid(contactName);
            bDay.setBirthday(sdf.parse(date_s));
            contactsDAO.addContact(contact, bDay);
            Reminder reminder = new Reminder();
            reminder.setUserid(userName);
            reminder.setDuration(hours);
            UserDAO.addHours(reminder);
        }
        
        try {
            SimpleEmail email = new SimpleEmail();
            email.setFrom("ska1296@gmail.com");
            email.addTo("ska1296@gmail.com");
            email.setSubject("subject");
            email.setMsg("Message");
            Mail.send(email); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        render(userName);
        
    }

}