package tacos.kitchen.messaging.rabbit.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tacos.kitchen.domain.ReceivedOrder;

@Component
@Profile("rabbitmq-listener")
@Slf4j
public class OrderListener {

    @RabbitListener(queues = "kitchen.central")
    public void receiveOrder(ReceivedOrder order) {

        log.info("Received order from queue: {}", order);
    }
}
