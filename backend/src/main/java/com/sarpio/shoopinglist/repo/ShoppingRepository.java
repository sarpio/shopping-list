package com.sarpio.shoopinglist.repo;

import com.sarpio.shoopinglist.model.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Piotr Sarnecki
 */
@Repository
public interface ShoppingRepository extends JpaRepository<ShoppingItem, Integer> {
}
