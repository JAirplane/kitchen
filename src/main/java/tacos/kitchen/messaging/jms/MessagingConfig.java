package tacos.kitchen.messaging.jms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import tacos.kitchen.domain.ReceivedOrder;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile({"jms-listener", "jms-template"})
public class MessagingConfig {

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTypeIdPropertyName("_typeId");

        Map<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("order", ReceivedOrder.class);
        converter.setTypeIdMappings(typeIdMappings);
        return converter;
    }
}
