package be.pxl.regendans.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Bunyamin
 */

@Entity
@Table(name="airPressure")
public class AirPressure{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "userid")
    private int userId;

    @Column(name = "locationid")
    private int locationId;

    @Column(name = "pressure")
    private float pressure;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Override
    public String toString(){
        return "Airpressure{id=" + id +
                ", userid=" + userId +
                ", locationid=" + locationId +
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}