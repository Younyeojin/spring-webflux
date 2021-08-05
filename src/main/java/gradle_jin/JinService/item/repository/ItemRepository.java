package gradle_jin.JinService.item.repository;

import gradle_jin.JinService.item.entity.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
}
