package com.example.mytravelmate;

import java.util.ArrayList;

public class Wishlist {
    private ArrayList<WishlistItem> items;

    public Wishlist() {
        items = new ArrayList<>();
    }

    public void addItem(WishlistItem item) {
        items.add(item);
    }

    public ArrayList<WishlistItem> getItems() {
        return items;
    }
}
