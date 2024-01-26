package com.dbproject.Models;

public class CartItem {
    private String itemName;
    private Double itemPrice;

    // Constructors, getters, and setters

    // Default constructor
    public CartItem() {
    }

    // Parameterized constructor
    public CartItem(String itemName, Double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    // Getter and Setter methods
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
