package hello.rest;
import hello.Email;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jms")
public class JmsRest {

    private final JmsTemplate jmsTemplate;

    public JmsRest(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping(value = "/{msg}")
    public Map<String, String> enviar(@PathVariable String msg) {
        jmsTemplate.convertAndSend("mailbox", "email json");
        final Map<String, String> map = new HashMap<>();
        map.put("retorno","200");
        return map;
    }
}
