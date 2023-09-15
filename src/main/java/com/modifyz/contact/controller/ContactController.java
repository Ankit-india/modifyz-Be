package com.modifyz.contact.controller;

import com.modifyz.contact.domain.Contact;
import com.modifyz.contact.dto.ContactDto;
import com.modifyz.contact.service.ContactService;
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

    @GetMapping(value = "/shop/{shopId}")
    public ResponseEntity<Contact> getContactByShopId(@PathVariable String shopId) {
        return new ResponseEntity<>(contactService.getContactByShopId(shopId), HttpStatus.OK);
    }

    @GetMapping(value = "/allContact")
    public ResponseEntity<List<ContactDto>> getAllContact() {
        return new ResponseEntity<>(contactService.getAllContact(), HttpStatus.OK);
    }
}
