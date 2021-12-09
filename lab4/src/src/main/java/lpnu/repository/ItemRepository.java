package lpnu.repository;

import lpnu.entity.Item;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {
    private List<Item> items;

    private long id = 1;


    @PostConstruct
    public void init() {
            items = new ArrayList<>();
    }

    public List<Item> getAllItem() {
        return new ArrayList<>(items);
    }

    public Item getItemById(final long id) {
        return items.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "item with id {" + id + "} not found"));
    }

    public Item saveItem(final Item item) {
        item.setId(id);

        ++id;

        items.add(item);
        return item;
    }

    public Item updateItem(final Item item) {

        final Item savedItem = getItemById(item.getId());

        savedItem.setPrice(item.getPrice());
        savedItem.setName(item.getName());

        return savedItem;
    }

    public void deleteItemById(final long id) {
        items = items.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }
}
