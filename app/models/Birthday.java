package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
@Table(name="BIRTHDAY")
public class Birthday extends Model {
    
    String userid;
    String birthday;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Birthday{" + "userid=" + userid + ", birthday=" + birthday + '}';
    }
    
}
