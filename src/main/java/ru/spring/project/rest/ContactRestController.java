package ru.spring.project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spring.project.model.Contact;
import ru.spring.project.service.ContactService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactRestController {

    @Autowired
    private ContactService contactService;

    //Get
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Contact> getContact(@PathVariable("id") Long customerId) {
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Contact contact = this.contactService.getById(customerId);
        if (contact == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = this.contactService.getAll();
        if (contacts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    //post
    @RequestMapping(value = "/contacts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Contact> saveContact(@RequestBody @Valid Contact contact) {
        HttpHeaders headers = new HttpHeaders();

        if (contact == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.contactService.save(contact);
        return new ResponseEntity<>(contact, headers, HttpStatus.CREATED);
    }

    //put
    @RequestMapping(value = "/contacts", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  ResponseEntity<Contact> updateContact(@RequestBody @Valid Contact contact){
        HttpHeaders headers = new HttpHeaders();

        if (contact == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.contactService.save(contact);
        return new ResponseEntity<>(contact, headers, HttpStatus.OK);

    }

    //delete
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Contact> deleteContact(@PathVariable("id") Long id) {
        Contact contact = this.contactService.getById(id);
        if (contact == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.contactService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
