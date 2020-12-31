package fr.univ.lille.aridepommiert.service;

import fr.univ.lille.aridepommiert.dao.BookDao;
import fr.univ.lille.aridepommiert.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookDao bookDao;

    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getAllBook() {
        return bookDao.findAll();
    }

    public Book createBook(Book book) {
        return bookDao.save(book);
    }

    public void deleteBook(Book book){
        bookDao.delete(book);
    }
}
