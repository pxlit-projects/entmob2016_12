package be.pxl.regendans.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Bunyamin
 */

@Entity
@Table(name="airpressure")
public class AirPressure{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "userid")
    private int userid;

    @Column(name = "pressure")
    private double pressure;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Override
    public String toString(){
        return "Airpressure{id=" + id +
                ", userid=" + userid +
                ", pressure=" + pressure +
                ", timestamp=" + timestamp +
                "}";
    }

    public boolean lowPressure(){
        return pressure > 1010.00;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}