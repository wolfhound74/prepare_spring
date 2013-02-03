package ru.maslov.contactmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.maslov.contactmanager.domain.Contact;
import ru.maslov.contactmanager.service.ContactService;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

//    @RequestMapping(method = RequestMethod.GET)
//    public String list(Model model) {
//        model.addAttribute("contactList", contactService.list());
//        return "contact/list";
//    }
//
//    @RequestMapping(value = "/create", method = RequestMethod.GET)
//    public String create(Model model) {
//        return "contact/edit";
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        HashMap<String, List<Contact>> model = new HashMap<String, List<Contact>>();
        model.put("contactList", contactService.list());
        return new ModelAndView("list", model);
    }
}
