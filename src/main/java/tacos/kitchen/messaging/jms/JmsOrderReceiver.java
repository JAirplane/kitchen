package tacos.kitchen.messaging.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import tacos.kitchen.domain.ReceivedOrder;
import tacos.kitchen.OrderReceiver;

@Component
@Profile("jms-template")
@Slf4j
public class JmsOrderReceiver implements OrderReceiver {

    @Value("${queue.name}")
    private String queueName;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public ReceivedOrder receiveOrder() {
        ReceivedOrder received = (ReceivedOrder) jmsTemplate.receiveAndConvert(queueName);
        log.info("Received object: {}", received);
        return received;
    }
}
