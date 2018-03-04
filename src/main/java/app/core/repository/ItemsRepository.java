package app.core.repository;

import app.core.model.Item;

import java.util.List;

/**
 * Created by User on 26.02.2018.
 */
public interface ItemsRepository {

    /**
     * Creates new item
     * @param name name of the new item
     * @return created item
     */
    Item create(String name);


    /**
     * Changes the existing item
     * @param item item to change
     * @return changed item
     */
    Item update(Item item);

    /**
     * Deletes item with needed id
     * @param id item's id
     * @return true if deletion was successful
     */
    boolean delete(int id);

    /**
     * Gets item by id number
     * @param id id number
     * @return Item object with needed id
     */
    Item getItemById(int id);

    /**
     * Gets all items from repository
     * @return list of Item objects
     */
    List<Item> getAllItems();
}