package gradle_jin.JinService.item.controller;

import gradle_jin.JinService.item.entity.Cart;
import gradle_jin.JinService.item.repository.CartRepository;
import gradle_jin.JinService.item.repository.ItemRepository;
import org.dom4j.util.AttributeHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@RestController
public class ItemController {
    private ItemRepository itemRepository;
    private CartRepository cartRepository;
    public ItemController(ItemRepository itemRepository, CartRepository cartRepository){
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }
    @GetMapping
    Mono<?> home(){
        return Mono.just(Rendering.view("home.html")
                .modelAttribute("items", this.itemRepositoy.findAll())
                .modelAttribute("cart", this.cartRepository.findById("My Cart")).defaultIfEmpty(new Cart("My Cart"))
                .build());
    }
    @PostMapping("/add/{id}")
    Mono<String> addToCart(@PathVariable String id){
        return this.cartRepository.findById("My Cart")
                .defaultIfEmpty(new Cart("My Cart"))
                .flatMap(cart -> cart.getCartItems()
                        .filter(cartItem -> cartItem.getItem()
                                .getId().equals(id))
                        .findAny()
                        .map(cartItem -> {
//                            cartItem.increment();
                            return Mono.just(cart);})
                        .ofElseGet(()->{
                            return this.itemRepository.findById(id)
                                    .map(item -> new CartItem(item))
                                    .map(cartItem -> {
                                        cart.getCartItems().add(cartItem);
                                        return cart;
                                    });
                        }))
                .flatMap(cart -> this.cartRepository.save(cart))
                .thenReturn("redirect:/");
    }
}
