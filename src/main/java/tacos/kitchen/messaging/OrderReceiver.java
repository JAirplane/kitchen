package tacos.kitchen.messaging;

import tacos.kitchen.domain.ReceivedOrder;

public interface OrderReceiver {
    ReceivedOrder receiveOrder();
}
