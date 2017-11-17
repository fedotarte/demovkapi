package com.example.demovkapi.dto.friendsdto;

import java.util.ArrayList;
import java.util.List;

public class FriendsDTO {
    private int count;
    private List<ItemDTO> items = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}
