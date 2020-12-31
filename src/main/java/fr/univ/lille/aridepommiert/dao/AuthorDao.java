package fr.univ.lille.aridepommiert.dao;

import fr.univ.lille.aridepommiert.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao extends CrudRepository<Author, Integer> {

    List<Author> findAll();

}
