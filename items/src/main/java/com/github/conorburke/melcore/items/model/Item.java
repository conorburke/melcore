package com.github.conorburke.melcore.items.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.hateoas.RepresentationModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name="items")
public class Item extends RepresentationModel<Item>{
    @Id
    @Column(name = "item_id", nullable = false)
    private String itemId;
    
    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "ownerId", nullable = false)
    private String ownerId;
}
