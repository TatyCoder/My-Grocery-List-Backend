package com.project.mygrocerylistbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grocery_list")
public class GroceryList {

    @Id
    @Column(name = "grocery_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groceryListId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "groceryList", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Item> items;

    public GroceryList(Long groceryListId, String name) {
        this.groceryListId = groceryListId;
        this.name = name;
    }

    public GroceryList() {
    }

    public Long getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(Long groceryListId) {
        this.groceryListId = groceryListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "groceryListId=" + groceryListId +
                ", name='" + name + '\'' +
                '}';
    }
}
