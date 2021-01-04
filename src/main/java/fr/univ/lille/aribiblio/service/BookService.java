package fr.univ.lille.aribiblio.service;

import fr.univ.lille.aribiblio.model.Book;
import fr.univ.lille.aribiblio.dao.BookDao;
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
        try{
            bookDao.delete(book);
        }catch (Exception e){

        }

    }

    public Book getById(Integer bookId) {
        return bookDao.findById(bookId).get();
    }
}
