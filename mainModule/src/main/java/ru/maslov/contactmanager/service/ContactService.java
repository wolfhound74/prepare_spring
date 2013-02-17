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
    public Contact get(Long id) {
       return contactDAO.get(id);
    }

    @Transactional
    public void save(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Transactional
    public List<Contact> list() {
        return contactDAO.list();
    }

    @Transactional
    public void delete(Long id) {
        contactDAO.delete(id);
    }
}
