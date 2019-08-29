package com.mensageria.artemis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(Sender.class);

  private final JmsTemplate jmsTemplate;

  public Sender(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
  }

  public void send(String message) {
    LOGGER.info("sending message='{}'", message);
    jmsTemplate.convertAndSend("helloworld.q", message);
  }
}