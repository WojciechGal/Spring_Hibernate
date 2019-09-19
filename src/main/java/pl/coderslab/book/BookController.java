package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;
import pl.coderslab.validation.BookValidationGroup;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    ////////////po dodaniu grup walidacji z 3go dnia działa jeszcze gorzej/////////

    private BookService bookService;

    private PublisherService publisherService;

    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

//    @GetMapping(value = "/add", produces = "text/html; charset=utf-8")
//    @ResponseBody
//    public String addBook() {
////////////////////////////////////////
//        Publisher publisher = new Publisher();
//        publisher.setName("Wydawca testowy");
//
//
/////////////////////////////
//        List<Author> authors = new ArrayList<>();
//        Author author = new Author();
//        author.setFirstName("Marcin");
//        author.setLastName("Kostka");
//
//        authors.add(author);
//
//
//
//
//
//        Book book = new Book();
//        book.setTitle("Władca pierścieni");
//
//
//        publisherService.savePublisher(publisher);
//        authorService.saveAuthor(author);
//
//        book.setPublisher(publisher);
//        book.setAuthors(authors);
//
//
//
//        bookService.saveBook(book);
//        return "dodano książkę o id: " + book.getId();
//    } ZMIENIAMY NA ZADANIE Z DRUGIEGO DNIA NA DOLE

    @GetMapping(value = "/add", produces = "text/html; charset=utf-8")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @PostMapping("/add")
    //3 dnia dodalismy walidacje!//////////////
    public String addBook(@ModelAttribute @Validated(BookValidationGroup.class) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book";
        }
        bookService.saveBook(book);
        return "redirect:list";
    }


    //DRUGI DZIEN

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }

    @GetMapping(value = "/list", produces = "text/html; charset=utf-8")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.findAll();
        //tu była podmianka 4 go dnia z find with authors ze starego serwisu





        //jakoś dziwnie sortuje te książki, pierszeństwo mają te z autorem
        model.addAttribute("books", books);
        return "bookList";
    }



    //////UPDATE///////////
///////PO DNIU 3 UPDATY NIE DZIALAJA BO NIE OBSLUGUJĄ WALIDACJI/////////////////
    @GetMapping(value = "/update/{id}", produces = "text/html; charset=utf-8")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookWithAuthors(id);
        model.addAttribute("book", book);
        return "book";
    }

    //to zadziała bez hidden w jsp bo jest w adresie id i on to zczytuje///jeśli by zadziałało mimo bez tego w adresie to znaczy że gdzieś tam krąży mimo wszystko...
//    @PostMapping(value = "/update/{id}", produces = "text/html; charset=utf-8")
//    public String updateBook(@ModelAttribute Book book) {
//        bookService.updateBook(book);
//        return "redirect:../list";
//    }



    ///////NOWY UPDATE Z 3-GO DNIA////////////////////////
    @PostMapping("/update/{id}")
    public String updateBook(@ModelAttribute @Validated(BookValidationGroup.class) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book";
        }
        bookService.updateBook(book);
        return "redirect:../list";
    }







    /////////////KASOWANIE/////////////////
    @GetMapping(value = "/delete/{id}", produces = "text/html; charset=utf-8")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:../list";
    }







    ///////////// 4 dzień!!! ////////////
    @GetMapping("/findByTitle")
    @ResponseBody
    public String findBook() {
        List<Book> books = bookService.findBooksByTitle("qweqwe");
        return books.toString();
    }

    @GetMapping("/findByCategoryId")
    @ResponseBody
    public String findBooksByCategoryId() {
        List<Book> books = bookService.findBooksByCategoryId(1L);
        return books.toString();
    }

    @GetMapping("/findByAuthorId/{id}")
    @ResponseBody
    public String findBooksByAuthorId(@PathVariable Long id) {
        List<Book> books = bookService.findBooksByAuthorsId(id);
        return books.toString();
    }

    @GetMapping("/findFirstBookByCategoryId/{id}")
    @ResponseBody
    public String findFirstBookByCategoryId(@PathVariable Long id) {
        Book book = bookService.findFirstBookByCategoryId(id);
        return book.toString();
    }

    @GetMapping("/findByRatingBetween")
    @ResponseBody
    public String findByRatingBetween() {
        List<Book> books = bookService.findByRatingBetween(4,7);
        return books.toString();
    }









    ////dzien 4 ostatni zadanie///////////////
    @GetMapping("/resetRating/{rating}")
    public String resetRating(@PathVariable int rating) {
        bookService.resetRating(rating);
        return "redirect:../list";
    }





































    ///////////////PIERWSZY DZIEN/////////////////!!!!!!!!!!!!!!!!!!!!!XDXDXDXDXDXDXDXDXDXDXDXDXDXD

//    @GetMapping(value = "/update/{id}", produces = "text/html; charset=utf-8")
//    @ResponseBody
//    public String updateBook(@PathVariable Long id) {
//        Book book = bookService.findBook(id);
//        book.setTitle("Pieśń Lodu i Ognia");
//        bookService.updateBook(book);
//        return "zupdatowano książkę o id " + book.getId();
//    }

    @GetMapping(value = "/{id}", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String findBook(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        return book.toString();
    }

//    @GetMapping(value = "/delete/{id}", produces = "text/html; charset=utf-8")
//    @ResponseBody
//    public String deleteBook(@PathVariable Long id) {
//        bookService.deleteBook(id);
//        return "usunięto książkę o id: " + id;
//    }





    @GetMapping(value = "/list/{rating}", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String getBooks(@PathVariable int rating) {
        List<Book> books = bookService.getRatingList(rating);
        return books.toString();
    }
}
