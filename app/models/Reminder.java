package models;

import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

@Entity
@Table(name="REMINDER")
public class Reminder extends Model {
    
    String userid;
    int duration;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Reminder{" + "userid=" + userid + ", duration=" + duration + '}';
    }
    
}
