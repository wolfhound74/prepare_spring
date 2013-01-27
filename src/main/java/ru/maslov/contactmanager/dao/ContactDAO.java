package ru.maslov.contactmanager.dao;

import ru.maslov.contactmanager.domain.Contact;

import java.util.List;

public interface ContactDAO {
    public void addContact(Contact contact);

    public List<Contact> list();

    public void remove(Long id);
}
