package models;

import javax.persistence.*;
import play.data.validation.Required;

import play.db.jpa.*;

@Entity
@Table(name="CONTACTS")
public class Contacts extends Model {
    
    
    @Required
    @Column(name="username")
    String username;
    
    @Column(name="contactName")
    @Required
    String contactName;
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Override
    public String toString() {
        return "Contacts{" + "username=" + username + ", contactName=" + contactName + '}';
    }
    
}
