package ru.maslov.contactmanager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.maslov.contactmanager.domain.Contact;

@Repository
public class ContactDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    public Contact getContact(Long id) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }
}
