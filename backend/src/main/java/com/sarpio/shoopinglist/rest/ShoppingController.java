package com.sarpio.shoopinglist.rest;

import com.sarpio.shoopinglist.config.ItemNotFoundException;
import com.sarpio.shoopinglist.model.ItemUnits;
import com.sarpio.shoopinglist.model.ShoppingItem;
import com.sarpio.shoopinglist.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Piotr Sarnecki
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
public class ShoppingController {

    private final ShoppingService service;

    @GetMapping("/list")
    public ResponseEntity<List<ShoppingItem>> getShoppingList() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ShoppingItem> getShoppingItemById(@PathVariable("id") Integer id) {
        try {
            ShoppingItem shoppingItem = service.getShoppingItem(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(shoppingItem);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/list")
    public ResponseEntity<ShoppingItem> addShoppingItem(@RequestBody ShoppingItem item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.storeShoppingItem(item));
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<Void> deleteShoppingItemById(@PathVariable("id") Integer id) {
        try {
            service.deleteShoppingItemById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
