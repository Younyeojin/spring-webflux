package gradle_jin.JinService.item.entity;

import lombok.RequiredArgsConstructor;

import javax.persistence.Id;
import javax.xml.catalog.Catalog;
import java.util.ArrayList;
@RequiredArgsConstructor
public class Cart {
    private @Id
    String id;
    private List<CartItem> cartItems;
//    private Cart(){}
    public Cart(String id){
        this(id, new ArrayList<>());
    }
    public Cart(String id, List<CartItem> cartItems){
        this.id = id;
        this.cartItems = cartItems;
    }
}
