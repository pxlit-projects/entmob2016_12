package be.regendans.spring.daos.mocks;

import be.regendans.spring.daos.UserDao;
import be.regendans.spring.entities.User;

import java.util.List;

/**
 * @author Bunyamin
 */
public class UserDaoMock implements UserDao {

    private boolean getUserByIdIsCalled = false;
    private boolean getAllUsersIsCalled = false;
    private boolean deleteUserByIdIsCalled = false;
    private boolean updateUserIsCalled = false;
    private boolean newUserIsCalled = false;

    public boolean isGetUserByIdCalled() {
        return getUserByIdIsCalled;
    }
    public boolean isGetAllUsersCalled() {
        return getAllUsersIsCalled;
    }
    public boolean isDeleteUserByIdCalled() {
        return deleteUserByIdIsCalled;
    }
    public boolean isUpdateUserCalled() {
        return updateUserIsCalled;
    }
    public boolean isNewUserCalled() {
        return newUserIsCalled;
    }

    @Override
    public User getUserById(int id) {
        getUserByIdIsCalled = true;
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        getAllUsersIsCalled = true;
        return null;
    }

    @Override
    public String deleteUserById(int id) {
        deleteUserByIdIsCalled = true;
        return null;
    }

    @Override
    public User updateUser(User u) {
        updateUserIsCalled = true;
        return null;
    }

    @Override
    public User newUser(User u) {
        newUserIsCalled = true;
        return null;
    }

}
