package app.core.repository;

/**
 * Created by User on 04.03.2018.
 */

import app.core.model.Item;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

public class DatabaseItemsRepository implements ItemsRepository {


    private JdbcOperations jdbcOperations;

    public DatabaseItemsRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Item create(final String name) {
        int id = getNextId();
        int insert = jdbcOperations.update(
                "INSERT INTO item (id, name) VALUES (?, ?)",
                id, name
        );
        return new Item(id, name);
    }

    @Override
    public Item update(Item newItem) {
        String name = newItem.getName();
        int id = newItem.getId();
        int rows = jdbcOperations.update(
                "UPDATE item SET name = ? WHERE id = ?",
                name, id);
        return new Item(id, name);
    }

    @Override
    public boolean delete(int id) {
        int rows = jdbcOperations.update(
                "DELETE FROM item WHERE id = ?",
                id
        );
        return rows > 0;

    }

    @Override
    public Item getItemById(int id) {
        return jdbcOperations.queryForObject(
                "SELECT id, name FROM item WHERE id = ?",
                (resultSet, i) -> {
                    int rowId = resultSet.getInt(1);
                    String rowName = resultSet.getString(2);
                    return new Item(rowId, rowName);
                },
                id);
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcOperations.query(
                "SELECT id, name FROM item",
                (resultSet, i) -> {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    return new Item(id, name);
                });

    }

    private int getNextId() {
        return jdbcOperations.queryForObject("select nextval('item_id_seq')", Integer.class);
    }
}
