package ru.maslov.contactmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maslov.contactmanager.dao.ContactDao;
import ru.maslov.contactmanager.domain.Contact;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDao contactDAO;

    @Transactional
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Transactional
    public List<Contact> list() {
        return contactDAO.list();
    }
}
