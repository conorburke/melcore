package com.github.conorburke.melcore.items.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import com.github.conorburke.melcore.items.model.Item;
import com.github.conorburke.melcore.items.service.ItemService;

@RestController
@RequestMapping(value="v1/users/{ownerId}/items")

public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value="/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable("ownerId") String ownerId, @PathVariable("itemId") String itemId) {

        Item item = itemService.getItem(itemId, ownerId);

        // HATEOS, shows links for the API. might add to this in future
        item.add(
            linkTo(methodOn(ItemController.class).getItem(ownerId, itemId)).withSelfRel(),
            linkTo(methodOn(ItemController.class).deleteItem(ownerId, itemId, null)).withRel("deleteItem")
        );

        return ResponseEntity.ok(item);
    }

    @PutMapping
    public ResponseEntity<Item> updateLicense(@PathVariable("ownerId") String ownerId, @RequestBody Item request, @RequestHeader(value = "Accept-language", required=false) Locale locale) {
        // return ResponseEntity.ok(itemService.updateItem(request, ownerId, locale));
        return ResponseEntity.ok(itemService.updateItem(request));
    }

    // the requestheader here is used to determine the language of the message to send back
    @PostMapping
    public ResponseEntity<Item> createItem(@PathVariable("ownerId") String ownerId, @RequestBody Item request, @RequestHeader(value = "Accept-language", required=false) Locale locale) {
        // return ResponseEntity.ok(itemService.createItem(request, ownerId, locale));
        return ResponseEntity.ok(itemService.createItem(request));
    }

    @DeleteMapping(value="/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("ownerId") String ownerId, @PathVariable("itemId") String itemId, @RequestHeader(value = "Accept-language", required=false) Locale locale) {
        // return ResponseEntity.ok(itemService.deleteItem(itemId, ownerId, locale));
        return ResponseEntity.ok(itemService.deleteItem(itemId));

    }
    
    
}
