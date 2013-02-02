package ru.maslov.contactmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.maslov.contactmanager.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        System.out.println("------------------");
        model.addAttribute("firstName", "Vladimir");
        model.addAttribute("lastName", "Maslov");
        System.out.println("--------");
        return "hello/index";
    }
}
