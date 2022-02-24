package com.project.mygrocerylistbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "grocery_list")
public class GroceryList {

    @Id
    @Column(name = "grocery_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groceryListId;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "user_id")
    private Long userId;

    public GroceryList(Long groceryListId, String name, Long userId) {
        this.groceryListId = groceryListId;
        this.name = name;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "groceryListId=" + groceryListId +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
