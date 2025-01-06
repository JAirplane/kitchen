package tacos.kitchen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tacos.kitchen.domain.ReceivedOrder;

@RestController
@RequestMapping(path = "/orders")
@Profile({"jms-template", "rabbitmq-template"})
@Slf4j
public class OrderReceiverController {

    private final OrderReceiver orderReceiver;

    @Autowired
    public OrderReceiverController(OrderReceiver orderReceiver) {
        this.orderReceiver = orderReceiver;
    }

    @GetMapping(path = "/receive")
    public ReceivedOrder getOrder() {
        ReceivedOrder order = orderReceiver.receiveOrder();
        log.info("Received new TacoOrder: {}", order);
        return order;
    }
}
