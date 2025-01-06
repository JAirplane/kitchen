package tacos.kitchen;

import tacos.kitchen.domain.ReceivedOrder;

public interface OrderReceiver {
    ReceivedOrder receiveOrder();
}
