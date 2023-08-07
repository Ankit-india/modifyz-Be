package com.modifyz.PanelApplicaton.commons.twilio.notificationService.impl;

import com.modifyz.PanelApplicaton.commons.twilio.constants.NotificationStatus;
import com.modifyz.PanelApplicaton.commons.twilio.convertor.NotificationConvertor;
import com.modifyz.PanelApplicaton.commons.twilio.dto.NotificationRequestDto;
import com.modifyz.PanelApplicaton.commons.twilio.dto.NotificationResponseDto;
import com.modifyz.PanelApplicaton.commons.twilio.notificationService.NotificationService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Autowired private Environment env;

    @Autowired private NotificationConvertor notificationConvertor;

    private String ACCOUNT_SID;

    private String AUTH_TOKEN;

    private Map<String, String> otpMap = new HashMap<>();

    public NotificationResponseDto sendSmsNotification(
        NotificationRequestDto notificationRequestDto) {
        String phoneNumber = getNormalizePhoneNumber(notificationRequestDto.getPhoneNumber());
        ACCOUNT_SID = env.getProperty("notification.modifyz.sid");
        AUTH_TOKEN = env.getProperty("notification.modifyz.authToken");
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        try {
            String otp = generateOtp();
            String msg = getMessage(otp);
            log.info(msg);
            Message message = Message.creator(
                new PhoneNumber(phoneNumber),     // from
                new PhoneNumber("+12059645491"),  // to
                msg).create();
            notificationResponseDto =
                notificationConvertor.convert(NotificationStatus.DELIVERED, msg, otp);
            otpMap.put(phoneNumber, otp);
            System.out.println(message.getSid());
        } catch (RuntimeException e) {
            notificationResponseDto =
                notificationConvertor.convert(NotificationStatus.FAILED, e.getMessage(), null);
        }
        return notificationResponseDto;
    }


    // TODO - This is the temporary solution need to get this otp with JWT token with expiry time extract otp from that
    public String validateOtp(NotificationRequestDto notificationRequestDto) {
        String phoneNumber = getNormalizePhoneNumber(notificationRequestDto.getPhoneNumber());

        if (otpMap.containsKey(phoneNumber)
            && notificationRequestDto.getOtp()
            .equals(otpMap.get(phoneNumber))) {
            otpMap.remove(phoneNumber);
            return NotificationStatus.VERIFIED.getDisplayName();
        }
        return NotificationStatus.NOT_VERIFIED.getDisplayName();
    }

    private String generateOtp() {
        return new DecimalFormat("000000").format(new Random().nextInt(999999));
    }

    private String getNormalizePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10) {
            return "+91" + phoneNumber;
        }
        return phoneNumber;
    }

    private String getMessage(String otp) {
        return ("Hello,\n"
            + "\n"
            + "Your One-Time Password (OTP) for verification is: "
            + otp
            + "\n"
            + "Please use this OTP to complete the process. It will expire in 5 minutes."
            + "\n"
            + "Modifyz-Team");
    }
}