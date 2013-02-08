package ru.maslov.contactmanager.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.ModelAndView;
import ru.maslov.contactmanager.domain.Contact;
import ru.maslov.contactmanager.service.ContactService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContactControllerTest extends AbstractControllerTest {

    private ContactService contactService;
    private final List<Contact> contactList = new ArrayList<Contact>();

    @Before
    public void init() {
        Contact contact = new Contact("Владимир", "Маслов");
        contactList.add(contact);
    }

    @Test
    public void test_list() {
        contactService = mock(ContactService.class);

        when(contactService.list()).thenReturn(contactList);

        ContactController controller = new ContactController();
        ReflectionTestUtils.setField(controller, "contactService", contactService);

        ModelAndView result = controller.list();
        assertEquals("list", result.getViewName());
        assertEquals(contactList, result.getModel().get("contactList"));
    }
}
