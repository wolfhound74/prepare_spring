package ru.maslov.contactmanager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.maslov.contactmanager.domain.Contact;

import java.util.List;

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

    public List<Contact> list() {
        return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    public void delete(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }

    public void delete(Long id) {
//        delete(getContact(id));
        org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery("delete from Contact where id=:id");
        query.setLong("id", id);
        int c = query.executeUpdate();
        System.out.println(c);
    }
}
