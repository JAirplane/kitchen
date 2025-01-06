package tacos.kitchen.messaging.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import tacos.kitchen.OrderReceiver;
import tacos.kitchen.domain.ReceivedOrder;

@Component
@Profile("rabbitmq-template")
public class RabbitOrderReceiver implements OrderReceiver {

    @Value("${queue.name}")
    private String queueName;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public ReceivedOrder receiveOrder() {
        return rabbitTemplate.receiveAndConvert(queueName,
                new ParameterizedTypeReference<ReceivedOrder>() {
                });
    }
}
