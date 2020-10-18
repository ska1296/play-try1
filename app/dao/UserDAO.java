package dao;

import java.util.List;
import models.Reminder;
import models.User;
import play.db.jpa.GenericModel;
public class UserDAO {

    public static void addHours(Reminder reminder) {
        GenericModel.JPAQuery bdayResult = Reminder.find(" from Reminder where userid = ?", reminder.getUserid());
        if (bdayResult.query.getResultList() == null || bdayResult.query.getResultList().isEmpty())
            reminder.save();
        else {
            Reminder.delete(" from Reminder where userid = ?", reminder.getUserid());
            reminder.save();
        }
    }
    
    public User findUser(String id) {
        return User.findById(id);
    }
    
    public List<User> getAllUsers() {
        return  User.findAll();
    }
    
}
