package com.modifyz.PanelApplicaton.contact.service;

import com.modifyz.PanelApplicaton.contact.domain.Contact;
import com.modifyz.PanelApplicaton.contact.dto.ContactDto;

public interface ContactService {

    Contact createOrUpdateContact(ContactDto contactDto);

    Contact getContactByShopId(String shopId);
}
