package fr.univ.lille.aribiblio.service;

import fr.univ.lille.aribiblio.dao.RentedDao;
import fr.univ.lille.aribiblio.dao.UserDao;
import fr.univ.lille.aribiblio.model.Rented;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentedService {

    private RentedDao rentedDao;

    private UserDao userDao;

    @Autowired
    public RentedService(RentedDao rentedDao, UserDao userDao) {
        this.rentedDao = rentedDao;
        this.userDao = userDao;
    }

    public List<Rented> getAll(){
        return this.rentedDao.findAll();
    }

    public void rentedBook(Integer bookId){
        this.rentedDao.save(new Rented(userDao.getUserByName(SecurityContextHolder.getContext().getAuthentication().getName()).getId(),bookId));
    }
}
