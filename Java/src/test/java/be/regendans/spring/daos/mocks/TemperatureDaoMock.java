package be.regendans.spring.daos.mocks;

import be.regendans.spring.daos.TemperatureDao;
import be.regendans.spring.entities.Temperature;

import java.util.List;

/**
 * @author Joren
 */
public class TemperatureDaoMock implements TemperatureDao{

    private boolean getTemperatureByIdIsCalled = false;
    private boolean getAllTemperaturesIsCalled = false;
    private boolean getAllUserTemperaturesIsCalled = false;
    private boolean updateTemperatureIsCalled = false;
    private boolean newTemperatureIsCalled = false;
    private boolean deltemperatureByIdIsCalled = false;

    public boolean isDeltemperatureByIdIsCalled() {
        return deltemperatureByIdIsCalled;
    }

    public boolean isGetAllTemperaturesIsCalled() {
        return getAllTemperaturesIsCalled;
    }

    public boolean isGetAllUserTemperaturesIsCalled() {
        return getAllUserTemperaturesIsCalled;
    }

    public boolean isGetTemperatureByIdIsCalled() {
        return getTemperatureByIdIsCalled;
    }

    public boolean isUpdateTemperatureIsCalled() {
        return updateTemperatureIsCalled;
    }

    public boolean isNewTemperatureIsCalled() {
        return newTemperatureIsCalled;
    }


    @Override
    public Temperature getTemperatureById(int id) {
        getTemperatureByIdIsCalled = true;
        return null;
    }

    @Override
    public List<Temperature> getAllTemperatures() {
        getAllTemperaturesIsCalled = true;
        return null;
    }

    @Override
    public List<Temperature> getAllUserTemperatures(int userId) {
        getAllUserTemperaturesIsCalled = true;
        return null;
    }

    @Override
    public Temperature updateTemperature(Temperature t) {
        updateTemperatureIsCalled = true;
        return null;
    }

    @Override
    public Temperature newTemperature(Temperature t) {
        newTemperatureIsCalled = true;
        return null;
    }

    @Override
    public String deltemperatureById(int id) {
        deltemperatureByIdIsCalled = true;
        return null;
    }

}
