package jobs;

import dao.ContactsDAO;
import dao.UserDAO;
import java.text.ParseException;
import java.util.List;
import models.Reminder;
import models.User;
import org.apache.commons.mail.SimpleEmail;
import play.jobs.*;
import play.libs.Mail;
 
@Every("31min")
public class MailCronJob extends Job {
    
    public void doJob() throws ParseException {
        List<User> newUsers = new UserDAO().getAllUsers();
        for(User user : newUsers) {
            List<Reminder> allContacts = new ContactsDAO().getReminderList(user.getUserid());
            sendMail(allContacts);
        }
    }
    
    public void sendMail(List<Reminder> allContacts) {
        StringBuilder reminder = new StringBuilder("Birthday reminder for:\n");
        
        for (Reminder eachOne : allContacts) {
            reminder.append(eachOne.getUserid() + " in " + eachOne.getDuration() + " hours\n");
        }
        try {
            SimpleEmail email = new SimpleEmail();
            email.setFrom("ska1296@gmail.com");
            email.addTo("ska1296@gmail.com");
            email.setSubject("with birthday");
            email.setMsg(reminder.toString());
            Mail.send(email); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

/*

*/