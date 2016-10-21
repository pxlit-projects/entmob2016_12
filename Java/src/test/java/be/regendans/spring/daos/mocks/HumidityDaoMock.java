package be.regendans.spring.daos.mocks;

import be.regendans.spring.daos.HumidityDao;
import be.regendans.spring.entities.Humidity;

import java.util.List;

/**
 * @author Joren
 */
public class HumidityDaoMock implements HumidityDao {

    private boolean getHumidityByIdIsCalled = false;
    private boolean getAllHumiditiesIsCalled = false;
    private boolean getAllUserHumiditiesIsCalled = false;
    private boolean newHumidityIsCalled = false;
    private boolean delHumidityByIdIsCalled = false;

    public boolean isDelHumidityByIdIsCalled() {
        return delHumidityByIdIsCalled;
    }

    public boolean isGetAllHumiditiesIsCalled() {
        return getAllHumiditiesIsCalled;
    }

    public boolean isGetAllUserHumiditiesIsCalled() {
        return getAllUserHumiditiesIsCalled;
    }

    public boolean isGetHumidityByIdIsCalled() {
        return getHumidityByIdIsCalled;
    }

    public boolean isNewHumidityIsCalled() {
        return newHumidityIsCalled;
    }
    @Override
    public Humidity gethumidityById(int id) {
        getHumidityByIdIsCalled = true;
        return null;
    }

    @Override
    public List<Humidity> getAllHumidities() {
        getAllHumiditiesIsCalled = true;
        return null;
    }

    @Override
    public List<Humidity> getAllUserHumidities(int userId) {
        getAllUserHumiditiesIsCalled = true;
        return null;
    }

    @Override
    public Humidity newHumidity(Humidity h) {
        newHumidityIsCalled = true;
        return null;
    }

    @Override
    public String delHumidityById(int id) {
        delHumidityByIdIsCalled = true;
        return null;
    }
}
