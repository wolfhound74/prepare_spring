package ru.maslov.contactmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.maslov.contactmanager.domain.Contact;
import ru.maslov.contactmanager.service.ContactService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @ResponseBody
    public String create(Contact contact, BindingResult bindingResult,
                          Model uiModel, HttpServletRequest httpServletRequest,
                          RedirectAttributes redirectAttributes, Locale locale) {
        contactService.save(contact);
        return "redirect:/contact/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        HashMap<String, List<Contact>> model = new HashMap<String, List<Contact>>();
        model.put("contactList", contactService.list());
        return new ModelAndView("list", model);
    }

    @RequestMapping(value = "/delete")
    public String delete(Long id) {
        contactService.delete(id);
        return "redirect:/contact/list";
    }
}
