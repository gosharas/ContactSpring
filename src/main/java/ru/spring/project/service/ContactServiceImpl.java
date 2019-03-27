package ru.spring.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.project.model.Contact;
import ru.spring.project.repository.ContactRepository;

import java.util.List;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact getById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void delete(Long id) {
        contactRepository.delete(id);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
}
