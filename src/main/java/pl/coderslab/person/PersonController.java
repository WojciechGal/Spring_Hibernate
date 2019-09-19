package pl.coderslab.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/add")
    public String add(Model md) {
        md.addAttribute("person", new Person());
        return "person";
    }

//    @PostMapping("/add")
//    @ResponseBody
//    public String add(@RequestParam String login, @RequestParam String password, @RequestParam String email) {
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personService.savePerson(person);
//        return "Saved person with id: " + person.getId();
//    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "Save person with id: " + person.getId();
    }


}
