package com.example.demo.controller;

import com.example.demo.dto.EmailRequestDto;
import com.example.demo.dto.EmailResponseDto;
import com.example.demo.service.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//myaccount.google.сom/app passwords   link to create password

@RestController
@Slf4j
public class EmailController {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/sendEmail")
    public EmailResponseDto sendEmail(@RequestBody EmailRequestDto emailRequestDto) {

        log.info("Request is {}",emailRequestDto);
        sendEmailService.sendEmail(emailRequestDto);
        log.info("Gmail sent successfully");
        return new EmailResponseDto("Send Successfully");
    }
}

