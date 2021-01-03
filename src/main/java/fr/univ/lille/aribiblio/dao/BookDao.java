package fr.univ.lille.aribiblio.dao;

import fr.univ.lille.aribiblio.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

    List<Book> findAll();

}
