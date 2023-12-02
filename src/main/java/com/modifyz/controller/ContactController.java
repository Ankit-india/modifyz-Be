package com.modifyz.controller;

import com.modifyz.entities.Contact;
import com.modifyz.dto.ContactDto;
import com.modifyz.services.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    @Autowired ContactService contactService;

    @PostMapping(value = "/")
    public ResponseEntity<Contact> create(@RequestBody  ContactDto contactDto) {
        Contact contact = contactService.createOrUpdateContact(contactDto);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    @GetMapping(value = "/shop/{contactId}")
    public ResponseEntity<Contact> getContactById(@PathVariable String contactId) {
        return new ResponseEntity<>(contactService.getContactById(contactId), HttpStatus.OK);
    }

    @GetMapping(value = "/allContact")
    public ResponseEntity<List<ContactDto>> getAllContact() {
        return new ResponseEntity<>(contactService.getAllContact(), HttpStatus.OK);
    }
}
