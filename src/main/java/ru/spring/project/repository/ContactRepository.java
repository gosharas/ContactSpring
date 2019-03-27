package ru.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spring.project.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
