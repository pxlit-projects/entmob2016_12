package be.regendans.spring.tests;

import be.regendans.spring.daos.mocks.UserLocationDaoMock;
import be.regendans.spring.testconfig.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Bunyamin
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@DirtiesContext
public class UserLocationDaoTest {

    @Autowired
    UserLocationDaoMock userLocationDaoMock;

    @Test
    public void testGetUserLocationById() {
        userLocationDaoMock.getUserLocationById(0);
        Assert.assertTrue(userLocationDaoMock.isGetUserLocationByIdIsCalled());
    }

    @Test
    public void testGetAllUserLocations() {
        userLocationDaoMock.getAllUserLocations();
        Assert.assertTrue(userLocationDaoMock.isGetAllUserLocationsIsCalled());
    }

    @Test
    public void testGetUserLocationByUserId() {
        userLocationDaoMock.getUserLocationByUserId(0);
        Assert.assertTrue(userLocationDaoMock.isGetUserLocationByUserIdIsCalled());
    }

    @Test
    public void testDeleteUserLocationById() {
        userLocationDaoMock.deleteUserLocationById(0);
        Assert.assertTrue(userLocationDaoMock.isDeleteUserLocationByIdIsCalled());
    }

    @Test
    public void testNewUserLocation() {
        userLocationDaoMock.newUserLocation(null);
        Assert.assertTrue(userLocationDaoMock.isNewUserLocationIsCalled());
    }
}
