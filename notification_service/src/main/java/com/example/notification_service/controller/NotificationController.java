package com.example.notification_service.controller;

import com.example.notification_service.model.ResultDetail;
import com.example.notification_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("")
    public void sendMail(@RequestBody ResultDetail resultDetail){
        String subject = "CHÚC MỪNG BẠN ĐÃ TRÚNG THƯỞNG";
        String contentText = "Khách hàng " + resultDetail.getCustomer().getName() +" " +
                "đã trúng thưởng vói mã code: " + resultDetail.getResult().getCode();
        emailService.sendMessage(resultDetail.getCustomer().getEmail(), subject, contentText);
    }
}
