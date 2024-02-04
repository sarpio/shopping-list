package com.sarpio.shoopinglist.service;

import com.sarpio.shoopinglist.repo.ShoppingRepository;
import com.sarpio.shoopinglist.config.ItemNotFoundException;
import com.sarpio.shoopinglist.model.ShoppingItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Piotr Sarnecki
 */
@Service
@RequiredArgsConstructor
public class ShoppingService {

    private final ShoppingRepository repository;

    public List<ShoppingItem> getAllItems() {
        return repository.findAll();
    }

    public ShoppingItem getShoppingItem(Integer id) {
        Optional<ShoppingItem> shoppingItemById = repository.findById(id);
        return shoppingItemById.orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }

    public ShoppingItem storeShoppingItem(ShoppingItem item) {
        return repository.save(item);
    }

    public void deleteShoppingItemById(Integer id) {
        ShoppingItem item = repository
                .findById(id)
                .orElseThrow(()->new ItemNotFoundException("ShoppingItem Not Found!"));
        repository.deleteById(id);
    }
}
