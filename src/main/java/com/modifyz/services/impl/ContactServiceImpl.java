package com.modifyz.services.impl;

import com.modifyz.convertor.ContactConvertor;
import com.modifyz.entities.Contact;
import com.modifyz.dto.ContactDto;
import com.modifyz.repositories.ContactRepository;
import com.modifyz.services.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactConvertor contactConvertor;

    @Autowired
    private ContactRepository contactRepository;

    @Override public Contact createOrUpdateContact(ContactDto contactDto) {
        Contact contact = contactConvertor.convert(contactDto);
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(String shopId) {
        return contactRepository.getContactById(shopId);
    }

    @Override public List<ContactDto> getAllContact() {
        List<Contact> contactList = contactRepository.findAll();
        List<ContactDto> contactDtoList = contactConvertor.convertToDtoList(contactList);

        return contactDtoList;
    }
}
