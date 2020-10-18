package models;

import java.util.Date;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
@Table(name="BIRTHDAY")
public class Birthday extends Model {
    
    
    @Column(name = "userid")
    String userid;
    
    @Temporal(value= TemporalType.TIMESTAMP)
    Date birthday;
    
    
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Birthday{" + "userid=" + userid + ", birthday=" + birthday + '}';
    }
    
}
