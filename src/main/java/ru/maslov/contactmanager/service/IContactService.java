package ru.maslov.contactmanager.service;

import ru.maslov.contactmanager.domain.Contact;

import java.util.List;

public interface IContactService {
    public void addContact(Contact contact);

    public List<Contact> list();

    public void remove(Long id);
}
