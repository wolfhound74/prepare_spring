package ru.maslov.contactmanager.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.maslov.contactmanager.domain.Contact;

import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    public List<Contact> list() {
        return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    @Override
    public void remove(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete Contact where id=:id");
        query.setLong("id", id);
        query.executeUpdate();
    }
}
