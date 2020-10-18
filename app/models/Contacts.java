package models;

import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
@Table(name="CONTACTS")
public class Contacts extends Model {
    
    String userid;
    String contactName;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    @Override
    public String toString() {
        return "Contacts{" + "userid=" + userid + ", contactName=" + contactName + '}';
    }
    
}
