package com.github.conorburke.melcore.items.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.github.conorburke.melcore.items.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, String> {
    public List<Item> findByOwnerId(String ownerId);
    public Item findByItemId(String itemId);
    public List<Item> findAll();
    // public Item findByOwnerIdAndItemId(String ownerId, String itemId);
}
