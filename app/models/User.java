package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
@Table(name="USERS")
public class User extends Model {
    
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
