package dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import models.Contacts;
import models.Birthday;
import models.Reminder;
import play.db.jpa.GenericModel;
public class ContactsDAO {
    
    public List<Contacts> findContactsByUser(String userid) {
        GenericModel.JPAQuery contactResult = Contacts.find(" from Contacts where username = ?", userid);
        return contactResult.query.getResultList();
    }
    
    public void addContact(Contacts contact, Birthday birthday) {
        
        GenericModel.JPAQuery contactResult = Contacts.find(" from Contacts where contactName = ? and username = ?", contact.getContactName(), contact.getUsername());
        if (contactResult.query.getResultList() == null || contactResult.query.getResultList().isEmpty())
            contact.save();
        
        GenericModel.JPAQuery bdayResult = Birthday.find(" from Birthday where userid = ?", birthday.getUserid());
        if (bdayResult.query.getResultList() == null || bdayResult.query.getResultList().isEmpty())
            birthday.save();
        else {
            Birthday.delete(" from Birthday where userid = ?", birthday.getUserid());
            birthday.save();
        }
    }
    
    public List<Reminder> getReminderList(String userId) throws ParseException {
        BirthdayDAO bDayDao = new BirthdayDAO();
        List<Reminder> remindersToSend = new ArrayList<Reminder>();
        List<Contacts> allContacts = findContactsByUser(userId);
        Reminder toAdd;
        for (Contacts eachContact : allContacts) {
            Birthday currBday = bDayDao.findByUser(eachContact.getContactName());
            
            Date d1 = currBday.getBirthday();
            Date d2 = new Date(); 
            
            int diff = Math.abs((int) TimeUnit.HOURS.convert(d2.getTime() - d1.getTime(), TimeUnit.MILLISECONDS));
            
            Reminder remind = (Reminder) Reminder.find("from Reminder where userid = ? and duration = ?", userId, diff).query.getSingleResult();
            if (remind != null) {
                toAdd = new Reminder();
                toAdd.setDuration(remind.getDuration());
                toAdd.setUserid(eachContact.getContactName());
                remindersToSend.add(toAdd);
            }
        }
        
        return remindersToSend;
        
    }
    
}
