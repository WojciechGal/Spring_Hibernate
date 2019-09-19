package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping("/findPublisherByRegon/{regon}")
    @ResponseBody
    public String findPublisherByRegon(@PathVariable String regon) {
        Publisher publisher = publisherService.findByRegon(regon);
        return publisher.toString();
    }
}
