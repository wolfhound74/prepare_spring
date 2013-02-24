package ru.maslov.contactmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maslov.contactmanager.dao.UserDao;
import ru.maslov.contactmanager.domain.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDAO;

    @Transactional
    public User get(Long id) {
       return userDAO.get(id);
    }

    @Transactional
    public void save(User user) {
        userDAO.addContact(user);
    }

    @Transactional
    public List<User> list() {
        return userDAO.list();
    }

    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
