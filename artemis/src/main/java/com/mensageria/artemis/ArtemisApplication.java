package com.mensageria.artemis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ArtemisApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(ArtemisApplication.class, args);


		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		// Send a message with a POJO - the template reuse the message converter
		System.out.println("Sending an email message.");
		jmsTemplate.convertAndSend("helloworld.q", "Email");
	}

}
