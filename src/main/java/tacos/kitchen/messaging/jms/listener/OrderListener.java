package tacos.kitchen.messaging.jms.listener;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tacos.kitchen.domain.ReceivedOrder;

@Component
@Data
@Profile("jms-listener")
@Slf4j
public class OrderListener {

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(ReceivedOrder order) {
      log.info("Received order from queue: {}", order);
    }
}
