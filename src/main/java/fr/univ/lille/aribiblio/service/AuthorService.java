package fr.univ.lille.aribiblio.service;

import fr.univ.lille.aribiblio.model.Author;
import fr.univ.lille.aribiblio.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorDao authorDao;

    @Autowired
    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public List<Author> getAllAuthor(){
        return this.authorDao.findAll();
    }

    public Author createAuthor(Author author){
        return this.authorDao.save(author);
    }

    public void deleteAuthor(Author author) {
        this.authorDao.delete(author);
    }
}
