package pl.coderslab.filtr_error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.author.Author;
import pl.coderslab.book.Book;
import pl.coderslab.publisher.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class FiltrErrorController {

    private Validator validator;

    @Autowired
    public FiltrErrorController(Validator validator) {
        this.validator = validator;
    }

//    @GetMapping(value = "/errors", produces = "text/html; charset=utf-8")
//    public String getErrors(Model model) {
//
//        Book book = new Book();
//
//        Set<ConstraintViolation<Book>> errors = validator.validate(book);
//
//        List<FiltrError> errorList = new ArrayList<>();
//
//        for (ConstraintViolation<Book> error : errors) {
//            String path = error.getPropertyPath().toString();
//            String message = error.getMessage();
//            errorList.add(new FiltrError(path, message));
//        }
//
//        model.addAttribute("errors", errorList);
//
//        return "errors";
//    }













//    @GetMapping(value = "/errors", produces = "text/html; charset=utf-8")
//    public String getErrors(Model model) {
//
//        Author author = new Author();
//
//        author.setPesel("123");
//        author.setEmail("qpa@q");
//
//        Set<ConstraintViolation<Author>> errors = validator.validate(author);
//
//        List<FiltrError> errorList = new ArrayList<>();
//
//        for (ConstraintViolation<Author> error : errors) {
//            String path = error.getPropertyPath().toString();
//            String message = error.getMessage();
//            errorList.add(new FiltrError(path, message));
//        }
//
//        model.addAttribute("errors", errorList);
//
//        return "errors";
//    }












    @GetMapping(value = "/errors", produces = "text/html; charset=utf-8")
    public String getErrors(Model model) {

        Publisher publisher = new Publisher();

        publisher.setNip("725-18-01-126");
        publisher.setRegon("12");

        Set<ConstraintViolation<Publisher>> errors = validator.validate(publisher);

        List<FiltrError> errorList = new ArrayList<>();

        for (ConstraintViolation<Publisher> error : errors) {
            String path = error.getPropertyPath().toString();
            String message = error.getMessage();
            errorList.add(new FiltrError(path, message));
        }

        model.addAttribute("errors", errorList);

        return "errors";
    }
}
