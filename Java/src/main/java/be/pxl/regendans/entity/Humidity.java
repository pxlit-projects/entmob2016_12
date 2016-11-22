package be.pxl.regendans.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

/**
 * @author Bunyamin
 */

@Entity
@Table(name="humidity")
public class Humidity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "userid")
    private int userid;

    @Column(name = "humidity")
    private double humidity;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public Humidity(int userid, double humidity, Timestamp timestamp) {
        this.userid = userid;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }

    public Humidity() {
    }

    @Override
    public String toString(){
        return "Humidity [id=" + id +
                ", userId=" + userid +
                ", humidity=" + humidity +
                ", timestamp=" + timestamp +
                "}";
    }

    public boolean moist(){
      return humidity > 75.00;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}