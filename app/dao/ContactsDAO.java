package dao;

import java.util.List;
import models.Contacts;
import models.Birthday;
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
    
}
