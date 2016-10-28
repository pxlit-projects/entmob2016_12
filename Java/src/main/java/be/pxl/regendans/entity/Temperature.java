package be.pxl.regendans.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Bunyamin
 */

@Entity
@Table(name="temperature")
public class Temperature{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "userid")
    private int userId;

    @Column(name = "locationid")
    private int locationId;

    @Column(name = "temperature")
    private float temperature;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Override
    public String toString(){
        return "Temperature{id=" + id +
                ", userid=" + userId +
                ", locationid=" + locationId +
                ", temperature=" + temperature +
                ", timestamp=" + timestamp +
                "}";
    }

    public boolean hot(){
        return temperature > 22;
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

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}