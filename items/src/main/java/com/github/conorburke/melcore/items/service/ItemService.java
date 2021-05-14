package com.github.conorburke.melcore.items.service;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.github.conorburke.melcore.items.config.ServiceConfig;
import com.github.conorburke.melcore.items.model.Item;
import com.github.conorburke.melcore.items.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
	MessageSource messages;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    ServiceConfig config;

    public List<Item> getItems() {
        // return itemRepository.findItems();
        return itemRepository.findAll();
    }

    public Item getItem(String itemId) {
        // Item item = new Item();
        // item.setItemId(itemId);
        // item.setOwnerId(ownerId);

        Item item = itemRepository.findByItemId(itemId);

        if (item == null) {
            throw new IllegalArgumentException(String.format(messages.getMessage("item.search.error.message", null, null), itemId));
        }

        return item;
    }

    public Item createItem(Item item){
		item.setItemId(UUID.randomUUID().toString());
		itemRepository.save(item);

		return item;
	}

    public Item updateItem(Item item){
		itemRepository.save(item);

		return item;
	}

    public String deleteItem(String itemId){
		String responseMessage = null;
		Item item = new Item();
		item.setItemId(itemId);
		itemRepository.delete(item);
		responseMessage = String.format(messages.getMessage("item.delete.message", null, null),itemId);
		return responseMessage;

	}

    // // if the Locale is null then it will default to english as set in the application
    // public String createItem(Item item, String ownerId, Locale locale) {

    //     String responseMessage = null;
    //     if (item != null) {
    //         item.setOwnerId(ownerId);
    //         // responseMessage = String.format("Item created with following attributes: %s\n", item.toString());
    //         responseMessage = String.format(messages.getMessage("item.create.message", null, locale), item.toString());
    //     }

    //     return responseMessage;
    // }

    // public String updateItem(Item item, String ownerId, Locale locale) {
    //     String responseMessage = null;
    //     if (!StringUtils.isEmpty(item)) {
    //         item.setOwnerId(ownerId);
    //         // responseMessage = String.format("Update called on item: %s\n", item.toString());
    //         responseMessage = String.format(messages.getMessage("item.update.message", null, locale), item.toString());
    //     }

    //     return responseMessage;
    // }

    // public String deleteItem(String itemId, String ownerId, Locale locale) {
    //     // return String.format("Deleting item: %s owned by owner: %s\n", itemId, ownerId);
    //     return String.format(messages.getMessage("item.delete.message", null, locale), itemId, ownerId);
    // }

}
