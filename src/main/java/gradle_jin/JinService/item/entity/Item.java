package gradle_jin.JinService.item.entity;

import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.Id;

public class Item {
    private @Id String id;
    private String name;
    private double price;
    private Item(){}
    Item(String name, double price){
        this.name = name;
        this.price = price;
    }
}
