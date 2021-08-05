package gradle_jin.JinService.item.entity;

public class CartItem {
    private Item item;
    private int quantity;
    private CartItem(){}
    CartItem(Item item){
        this.item = item;
        this.quantity = 1;
    }
}
