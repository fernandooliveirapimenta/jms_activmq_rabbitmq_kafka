package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(String email) {
        System.out.println("Received <" + email + ">");
    }

    @JmsListener(destination = "topicFernando",containerFactory = "myFactory")
    public void topic(String msg) {
        System.out.println("topic <" + msg + ">");
    }

}
