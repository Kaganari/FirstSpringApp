package core.repository;

import core.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 26.02.2018.
 */
public class SampleItemsRepository implements ItemsRepository {

    private List<Item> items = new ArrayList<Item>();
    private List<Integer> IDs = new ArrayList<Integer>();

    public SampleItemsRepository() {
        items.add(new Item(1, "one"));
        IDs.add(1);
        items.add(new Item(2, "two"));
        IDs.add(2);
        items.add(new Item(3, "three"));
        IDs.add(3);
    }

    @Override
    public List<Item> getAllItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public Item create(final String name) {
        items.add(new Item(IDs.size()+1,name));
        IDs.add(IDs.size()+1);
        //IDs.size()+1 is the ID of the new created Item
        return items.get(IDs.size()+1);
    }

    @Override
    public Item update(final int id) {
        return null;
    }

    @Override
    public Item update(final Item item) {
        return null;
    }

    @Override
    public boolean delete(final int id) {
        return items.remove(this.getItemById(id));
    }

    @Override
    public Item getItemById(final int id) {
        for (Item item : items) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }
}
