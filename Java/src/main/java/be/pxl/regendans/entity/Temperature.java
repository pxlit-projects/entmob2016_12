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
    private int userid;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public Temperature() {
    }

    public Temperature(int userid, double temperature, Timestamp timestamp) {
        this.userid = userid;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "Temperature{id=" + id +
                ", userid=" + userid +
                ", temperature=" + temperature +
                ", timestamp=" + timestamp +
                "}";
    }

    public boolean cold(){
        return temperature < 20;
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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}