package be.pxl.regendans.builders;

import be.pxl.regendans.entity.Humidity;

import java.sql.Timestamp;

public class HumidityBuilder {
    private int userid;
    private double humidity;
    private int id;
    private Timestamp timestamp;

    public static HumidityBuilder humidity() {
        return new HumidityBuilder();
    }


    public HumidityBuilder setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public HumidityBuilder setHumidity(double humidity) {
        this.humidity = humidity;
        return this;
    }

    public HumidityBuilder setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Humidity build() {
        return new Humidity(userid, humidity,timestamp);
    }
}