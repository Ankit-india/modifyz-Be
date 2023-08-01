package com.modifyz.PanelApplicaton.contact.controller;

import com.modifyz.PanelApplicaton.contact.domain.Contact;
import com.modifyz.PanelApplicaton.contact.dto.ContactDto;
import com.modifyz.PanelApplicaton.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
}
