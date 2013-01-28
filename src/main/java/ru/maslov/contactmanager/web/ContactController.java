package ru.maslov.contactmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.maslov.contactmanager.domain.Contact;
import ru.maslov.contactmanager.service.ContactService;

import java.util.Map;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {

        map.put("contact", new Contact());
        map.put("contactList", contactService.list());

        return "contact";
    }


}
