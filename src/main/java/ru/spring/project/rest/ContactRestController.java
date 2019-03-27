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
    public ResponseEntity<Contact> getCustomer(@PathVariable("id") Long customerId) {
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Contact customer = this.contactService.getById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Contact>> getAllCustomers() {
        List<Contact> customers = this.contactService.getAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //post
    @RequestMapping(value = "/contacts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Contact> saveCustomer(@RequestBody @Valid Contact customer) {
        HttpHeaders headers = new HttpHeaders();

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.contactService.save(customer);
        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

    //delete
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Contact> deleteCustomer(@PathVariable("id") Long id) {
        Contact customer = this.contactService.getById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.contactService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
