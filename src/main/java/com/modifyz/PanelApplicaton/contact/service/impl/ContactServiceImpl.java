package com.modifyz.PanelApplicaton.contact.service.impl;

import com.modifyz.PanelApplicaton.contact.convertor.ContactConvertor;
import com.modifyz.PanelApplicaton.contact.domain.Contact;
import com.modifyz.PanelApplicaton.contact.dto.ContactDto;
import com.modifyz.PanelApplicaton.contact.repository.ContactRepository;
import com.modifyz.PanelApplicaton.contact.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactConvertor contactConvertor;

    @Autowired
    private ContactRepository contactRepository;

    @Override public Contact createOrUpdateContact(ContactDto contactDto) {
        Contact contact = contactConvertor.convert(contactDto);
        Contact savedContact = contactRepository.save(contact);
        return savedContact;
    }

    @Override public Contact getContactByShopId(String shopId) {
        return contactRepository.getContactByShopId(shopId);
    }

    @Override public List<ContactDto> getAllContact() {
        List<Contact> contactList = contactRepository.findAll();
        List<ContactDto> contactDtoList = contactConvertor.convertToDtoList(contactList);

        return contactDtoList;
    }
}
