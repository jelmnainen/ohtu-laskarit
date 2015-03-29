package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        boolean invalid = false;
        
        if(this.usernameIsInvalid(username)){
            invalid = true;
        }
        
        if(this.passwordIsInvalid(password)){
            invalid = true;
        }

        return invalid;
    }

    private boolean passwordIsInvalid(String password) {
        boolean invalid = false;
        
        if(password.length() < 8){
            invalid = true;
        }
        
        if(!password.matches(".*\\d+.*")){
            invalid = true;
        }
        
        return invalid;
    }

    private boolean usernameIsInvalid(String username) {
        boolean invalid = false;
        
        if(username.length() < 2){
            invalid = true;
        }
        
        return invalid;
    }
}
