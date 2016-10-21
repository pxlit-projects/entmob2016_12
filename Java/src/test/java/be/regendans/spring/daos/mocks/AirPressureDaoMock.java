package be.regendans.spring.daos.mocks;

import be.regendans.spring.daos.AirPressureDao;
import be.regendans.spring.entities.AirPressure;

import java.util.List;

/**
 * @author Joren
 */
public class AirPressureDaoMock implements AirPressureDao{
    private boolean getAirPressureByIdIsCalled = false;
    private boolean getAllAirPressuresIsCalled = false;
    private boolean getAllUserAirPressuresIsCalled = false;
    private boolean newAirPressureIsCalled = false;
    private boolean delAirPressureByIdIsCalled = false;

    public boolean isDelAirPressureByIdIsCalled() {
        return delAirPressureByIdIsCalled;
    }

    public boolean isGetAllAirPressuresIsCalled() {
        return getAllAirPressuresIsCalled;
    }

    public boolean isGetAllUserAirPressuresIsCalled() {
        return getAllUserAirPressuresIsCalled;
    }

    public boolean isGetAirPressureByIdIsCalled() {
        return getAirPressureByIdIsCalled;
    }

    public boolean isNewAirPressureIsCalled() {
        return newAirPressureIsCalled;
    }

    @Override
    public AirPressure getAirPressureById(int id) {
        getAirPressureByIdIsCalled = true;
        return null;
    }

    @Override
    public List<AirPressure> getAllAirPressures() {
        getAllAirPressuresIsCalled = true;
        return null;
    }

    @Override
    public List<AirPressure> getAllUserAirPressures(int userId) {
        getAllUserAirPressuresIsCalled = true;
        return null;
    }

    @Override
    public AirPressure newAirPressure(AirPressure a) {
        newAirPressureIsCalled = true;
        return null;
    }

    @Override
    public String delAirPressureById(int id) {
        delAirPressureByIdIsCalled = true;
        return null;
    }
}
