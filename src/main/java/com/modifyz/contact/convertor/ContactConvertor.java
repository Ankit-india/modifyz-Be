package com.modifyz.contact.convertor;

import com.modifyz.contact.domain.Contact;
import com.modifyz.contact.dto.ContactDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class ContactConvertor {

    public Contact convert(ContactDto contactDto) {
        return Contact.Builder.contact()
            .withShopId(contactDto.getShopId())
            .withMobileNumber(contactDto.getMobileNumber())
            .withAlternateMobileNumber(contactDto.getAlternateMobileNumber())
            .withAddress(contactDto.getAddress())
            .build();
    }

    public ContactDto convertToDto(Contact contact) {
        return ContactDto.Builder.contactDto()
            .withShopId(contact.getShopId())
            .withMobileNumber(contact.getMobileNumber())
            .withAlternateMobileNumber(contact.getAlternateMobileNumber())
            .withAddress(contact.getAddress())
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
