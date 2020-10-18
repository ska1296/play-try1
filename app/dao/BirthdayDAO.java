package dao;


import models.Birthday;
import play.db.jpa.GenericModel;
public class BirthdayDAO {
    
    public Birthday findByUser(String userid) {
        GenericModel.JPAQuery contactResult = Birthday.find(" from Birthday where userid = ?", userid);
        return contactResult.query.getSingleResult() == null ? null : (Birthday) contactResult.query.getSingleResult();
    }
    
}
