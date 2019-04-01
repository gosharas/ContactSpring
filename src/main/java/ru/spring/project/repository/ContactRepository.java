package ru.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.project.model.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
