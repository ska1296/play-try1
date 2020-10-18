package models;

import javax.persistence.*;
import play.data.validation.Required;
 
import play.db.jpa.*;

@Entity
@Table(name="USERS")
public class User extends GenericModel {
    
    @Id
    @Required
    String userid;
    String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", password=" + password + '}';
    }
    
}
