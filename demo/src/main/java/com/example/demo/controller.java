package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	@Autowired
    private JavaMailSender javaMailSender;

	@RequestMapping("/success")
	void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("thanushareddy0305@gmail.com");
        msg.setFrom("thanushareddy0305@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
        System.out.println("done..!!");

    }
	
}
