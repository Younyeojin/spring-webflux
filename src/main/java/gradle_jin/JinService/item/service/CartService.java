package gradle_jin.JinService.item.service;

import gradle_jin.JinService.item.entity.Cart;
import gradle_jin.JinService.item.entity.CartItem;
import gradle_jin.JinService.item.repository.CartRepository;
import gradle_jin.JinService.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
@Service
public class CartService {
    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    Mono<Cart> addToCart(String cartId, String id){
        return this.cartRepository.findById(cartId)
                .defaultIfEmpty(new Cart(cartId))
                .flatMap(cart -> cart.getCartItems().stream()
                        .getId().equals(id))
                .findAny()
                .map(cartItem -> {
                    cartItem.increment();
                    return Mono.just(cart);
                })
                .ofElseGet(()->this.itemRepository.findById((id)
                        .map(CartItem::new)
                        .doOnNext(cartItem -> cart.getCartItems().add(cartItem))
                        .map(cartItem -> cart)))
                .flatMap(this.cartRepository::save);
    }
}
