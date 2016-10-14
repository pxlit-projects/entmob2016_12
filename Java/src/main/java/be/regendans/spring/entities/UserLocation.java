package be.regendans.spring.entities;

import javax.persistence.*;

/**
 * @author Bunyamin
 */

@Entity
@Table(name="userlocation")
public class UserLocation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "userid")
    private int userId;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "longitude")
    private float longitude;

    @Override
    public String toString(){
        return "UserLocation{" +
                "id=" + id +
                ", userid=" + userId +
                ", latitude=" + latitude  +
                ", longitude=" +longitude +
                "}";
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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
