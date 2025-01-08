package tacos.kitchen.messaging.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tacos.kitchen.domain.ReceivedOrder;

@Component
@Profile("kafka-listener")
@Slf4j
public class OrderListener {

    @KafkaListener(topics = "orders")
    public void receiveOrder(ReceivedOrder order) {
        log.info("Received order from queue: {}", order);
    }
}
