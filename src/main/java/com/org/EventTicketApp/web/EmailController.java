/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.web;

import com.org.EventTicketApp.Services.EmailSenderService;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEEV
 */
@RestController
@CrossOrigin(origins ="http://localhost:3000" )
public class EmailController {
  @Autowired
private EmailSenderService emailservice;
  
  @PostMapping(value = "/sendinvitation" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public String sendEmail(@RequestParam(value = "destination")  String destination , @RequestParam(value = "subject") String subject , @RequestParam(value = "content") String content ) throws AddressException, MessagingException, IOException {
        emailservice.sendmail(destination , subject , "You Are Invited  : "+content );
        return "Email sent successfully";

    }
}
