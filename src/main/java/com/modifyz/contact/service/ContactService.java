package com.modifyz.contact.service;

import com.modifyz.contact.domain.Contact;
import com.modifyz.contact.dto.ContactDto;
import java.util.List;

public interface ContactService {

    Contact createOrUpdateContact(ContactDto contactDto);

    Contact getContactByShopId(String shopId);

    List<ContactDto> getAllContact();
}
