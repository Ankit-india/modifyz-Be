package com.modifyz.services;

import com.modifyz.entities.Contact;
import com.modifyz.dto.ContactDto;
import java.util.List;

public interface ContactService {

    Contact createOrUpdateContact(ContactDto contactDto);

    Contact getContactById(String Id);

    List<ContactDto> getAllContact();
}
