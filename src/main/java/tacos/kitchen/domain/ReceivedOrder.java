package tacos.kitchen.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ReceivedOrder {

    private Date placedAt;

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
//    private String ccNumber;
//    private String ccExpiration;
//    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

//    public void addTaco(Taco design) {
//
//        tacos.add(design);
//    }
}
