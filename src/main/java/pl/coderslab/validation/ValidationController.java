package pl.coderslab.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.book.Book;
import pl.coderslab.filtr_error.FiltrError;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    private Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

//    @GetMapping(value = "/validate", produces = "text/html; charset=utf-8")
//    @ResponseBody
//    public String validate() {
//        Book book = new Book();
//        Set<ConstraintViolation<Book>> errors =  validator.validate(book);
//
//        StringBuilder sb = new StringBuilder();
//
//        for(ConstraintViolation<Book> error : errors) {
//            sb.append(error.getPropertyPath()).append(": ").append(error.getMessage()).append("<br>");
//        }
//
//        return sb.toString();
//    }



    @RequestMapping(path = "/validateAuthor", produces = "text/html; charset=utf-8")
    public String validateAuthor(Model model) {
        Author author = new Author();
        author.setEmail("j.zytka@wp.pl");
        author.setPesel("97111312378");
        author.setYearOfBirth(2002);
        List<FiltrError> list = new ArrayList<>();
        Set<ConstraintViolation<Author>> errors = validator.validate(author);
        for (ConstraintViolation<Author> error : errors) {
            FiltrError filterError = new FiltrError();
            filterError.setPath(error.getPropertyPath().toString());
            filterError.setMessage(error.getMessage());
            list.add(filterError);
        }

        model.addAttribute("errors", list);
        return "errors";
    }
}
