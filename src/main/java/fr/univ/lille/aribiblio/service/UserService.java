package fr.univ.lille.aribiblio.service;

import fr.univ.lille.aribiblio.dao.UserDao;
import fr.univ.lille.aribiblio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User createUser(User user){
        return this.userDao.save(user);
    }

    public User getUser(String user){
        return this.userDao.getUserByName(user);
    }

    public User getUserById(Integer user){
        return this.userDao.findById(user).get();
    }

}
