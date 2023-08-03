package com.modifyz.PanelApplicaton.contact.convertor;

import com.modifyz.PanelApplicaton.contact.domain.Contact;
import com.modifyz.PanelApplicaton.contact.dto.ContactDto;
import java.util.Map;
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
}
