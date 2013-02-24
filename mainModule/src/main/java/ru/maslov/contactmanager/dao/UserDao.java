package ru.maslov.contactmanager.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.maslov.contactmanager.domain.User;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addContact(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User get(Long id) {
        return (User) sessionFactory.getCurrentSession().load(User.class, id);
    }

    public List<User> list() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public void delete(Long id) {
//        delete(getContact(id));
        Query query = sessionFactory.getCurrentSession().createQuery("delete from User where id=:id");
        query.setLong("id", id);
        int c = query.executeUpdate();
        System.out.println(c);
    }
}
