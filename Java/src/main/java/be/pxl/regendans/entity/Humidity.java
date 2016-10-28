//package be.pxl.regendans.entity;
//
//import java.sql.Timestamp;
//import java.util.Date;
//import javax.persistence.*;
//
///**
// * @author Bunyamin
// */
//
//@Entity
//@Table(name="humidity")
//public class Humidity{
//
//    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "userid")
//    private int userId;
//
//    @Column(name = "locationid")
//    private int locationId;
//
//    @Column(name = "humidity")
//    private float humidity;
//
//    @Column(name = "timestamp")
//    private Timestamp timestamp;
//
//    @Override
//    public String toString(){
//        return "Humidity [id=" + id +
//                ", userid=" + userId +
//                ", locationid=" + locationId +
//                ", humidity=" + humidity +
//                ", timestamp=" + timestamp +
//                "}";
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public int getLocationId() {
//        return locationId;
//    }
//
//    public void setLocationId(int locationId) {
//        this.locationId = locationId;
//    }
//
//    public float getHumidity() {
//        return humidity;
//    }
//
//    public void setHumidity(float humidity) {
//        this.humidity = humidity;
//    }
//
//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Timestamp timestamp) {
//        this.timestamp = timestamp;
//    }
//}