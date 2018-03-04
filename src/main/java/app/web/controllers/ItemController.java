package app.web.controllers;

import app.core.model.Item;
import app.core.repository.ItemsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by User on 05.03.2018.
 */
public class ItemController {
    private final ItemsRepository itemsRepository;

    public ItemController(final ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Item> get(@PathVariable int id) {
        Item result = itemsRepository.getItemById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Item> update(@RequestBody Item newItem) {
        Item result = itemsRepository.update(newItem);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI location = UriComponentsBuilder.fromPath("/items/")
                    .path(String.valueOf(result.getId()))
                    .build().toUri();
            return ResponseEntity.created(location).body(result);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable int id) {
        boolean toDelete = itemsRepository.delete(id);
        if (toDelete) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
