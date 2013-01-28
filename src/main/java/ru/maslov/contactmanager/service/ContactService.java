package ru.maslov.contactmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maslov.contactmanager.dao.ContactDAOImpl;
import ru.maslov.contactmanager.domain.Contact;

import java.util.List;

@Service
public class ContactService implements IContactService {

    @Autowired
    ContactDAOImpl contactDAO;

    @Override
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Override
    public List<Contact> list() {
        return contactDAO.list();
    }

    @Override
    public void remove(Long id) {
        contactDAO.remove(id);
    }
}
