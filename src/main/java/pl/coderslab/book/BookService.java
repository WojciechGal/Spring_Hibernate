package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

//    private BookDao bookDao;
//
//    @Autowired
//    public BookService(BookDao bookDao) {
//        this.bookDao = bookDao;
//    }
//
//    public void saveBook(Book book) {
//        bookDao.saveBook(book);
//    }
//
//    public void updateBook(Book book) {
//        bookDao.updateBook(book);
//    }
//
//    public Book findBook(Long id) {
//        return bookDao.findBook(id);
//    }
//
//    public void deleteBook(Long id) {
//        bookDao.deleteBook(id);
//    }
//
//    public List<Book> getRatingList(int rating) {
//        return bookDao.getRatingList(rating);
//    }
//
//    public List<Book> findAll() {
//        return bookDao.getAll();
//    }
//
//
//
//
//
//
//
//
//    public Book findBookWithAuthors (Long id) {
//        Book book = bookDao.findBook(id);
//        Hibernate.initialize(book.getAuthors());
//        return book;
//    }
//
//    public List<Book> findBooksWithAuthors () {
//        return bookDao.getAllWithAuthors();
//    }
//
//
//
//
//
//
//
//
//
//    public List<Book> findAllPropositions() {
//        return bookDao.findAllPropositions();
//    }









    /////wyżej wykomentowane a to podmianka z 4go dnia///////////
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public Book findBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book findBookWithAuthors(Long id) {
        Book book = findBook(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getRatingList(int rating) {
        return bookRepository.findByRatingGreaterThan(rating);
    }

    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        books.forEach(b -> Hibernate.initialize(b.getAuthors()));
        return books;
    }

    public List<Book> findAllPropositions() {
        return bookRepository.findByPropositionTrue();
    }

    /////zadanie 2///////////

    public List<Book> findBooksByTitle(String title) {
        //return bookRepository.findByTitle(title);
        ///podmianka
        return bookRepository.findByTitleQuery(title);

    }

    public List<Book> findBooksByCategoryId(Long id) {
        return bookRepository.findByCategoryId(id);
    }

    public List<Book> findBooksByAuthorsId(Long id) {
        return bookRepository.findByAuthorsId(id);
    }

    public Book findFirstBookByCategoryId(Long categoryId) {
        return bookRepository.findFirstByCategoryIdOrderByTitleAsc(categoryId);
    }



    ////2 czesc zadan/////////

    public List<Book> findByRatingBetween(Integer num1, Integer num2) {
        return bookRepository.findByRatingBetween(num1, num2);
    }












    ////dzien 4 ostatni zadanie///////////////
    public void resetRating(int rating) {
        /////////Spring data składa to do kupy, TO I TO  Z BDD4I
        bookRepository.resetRating(rating);
    }
    

}
