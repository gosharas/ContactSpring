package ru.spring.project.service;

import ru.spring.project.model.Contact;

import java.util.List;

public interface ContactService {

    Contact getById(Long id);

    void save(Contact contact);

    void delete(Long id);

    List<Contact> getAll();
}
