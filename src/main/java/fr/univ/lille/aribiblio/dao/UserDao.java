package fr.univ.lille.aribiblio.dao;

import fr.univ.lille.aribiblio.model.Book;
import fr.univ.lille.aribiblio.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
    public User getUserByName(String name);
}
