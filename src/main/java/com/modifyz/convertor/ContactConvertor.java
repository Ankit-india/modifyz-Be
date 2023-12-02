package com.modifyz.convertor;

import com.modifyz.dto.ContactDto;
import com.modifyz.entities.Contact;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ContactConvertor {

    public Contact convert(ContactDto contactDto) {
        return Contact.Builder.contact()
            .withMobileNumber(contactDto.getMobileNumber())
            .withAlternateMobileNumber(
                contactDto.getAlternateMobileNumber())
            .withAddress(contactDto.getAddress())
            .withPincode(contactDto.getPincode())
            .build();
    }

    public ContactDto convertToDto(Contact contact) {
        return ContactDto.Builder.contactDto()
            .withMobileNumber(contact.getMobileNumber())
            .withAlternateMobileNumber(contact.getAlternateMobileNumber())
            .withAddress(contact.getAddress())
            .withPincode(contact.getPincode())
            .build();
    }

    public List<ContactDto> convertToDtoList(List<Contact> contactList) {
        List<ContactDto> contactDtoList = contactList.stream()
            .map(contact -> {
                ContactDto contactDto = convertToDto(contact);
                return contactDto;
            })
            .collect(Collectors.toList());

        return contactDtoList;
    }
}
