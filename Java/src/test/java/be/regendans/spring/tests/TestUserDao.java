package be.regendans.spring.tests;

import be.regendans.spring.daos.mocks.UserDaoMock;
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
public class TestUserDao {

    @Autowired
    private UserDaoMock userDaoMock;

    @Test
    public void testGetUserById(){
        userDaoMock.getUserById(0);
        Assert.assertTrue(userDaoMock.isGetUserByIdCalled());
    }

    @Test
    public void testGetAllUsers(){
        userDaoMock.getAllUsers();
        Assert.assertTrue(userDaoMock.isGetAllUsersCalled());
    }

    @Test
    public void testDeleteUser(){
        userDaoMock.deleteUserById(0);
        Assert.assertTrue(userDaoMock.isDeleteUserByIdCalled());
    }

    @Test
    public void testUpdateUserById(){
        userDaoMock.updateUser(null);
        Assert.assertTrue(userDaoMock.isUpdateUserCalled());
    }

    @Test
    public void testNewUser(){
        userDaoMock.newUser(null);
        Assert.assertTrue(userDaoMock.isGetAllUsersCalled());
    }
}
