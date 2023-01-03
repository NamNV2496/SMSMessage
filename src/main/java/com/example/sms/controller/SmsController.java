package com.example.sms.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    @Value("${twilio.account_sid}")
    private String account;
    @Value("${twilio.auth_token}")
    private String token;
    @Value("${twilio.trial_phone}")
    private String phone;

    @GetMapping("/sendSMS")
    public String sendSMS() {

        Twilio.init(account, token);

        Message.creator(new PhoneNumber("+84978147980"),
                new PhoneNumber(phone), "Hello from Twilio ").create();

        return "Message sent successfully";
    }
}
