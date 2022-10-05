package fr.liva.inventory;

import fr.liva.inventory.items.Item;
import lombok.Getter;

import java.util.List;

@Getter
public class Inventory {

    private InventoryType type;

    private int size;

    private List<Item> items;

    public Inventory(InventoryType type, int size, List<Item> items) {
        this.type = type;
        this.size = size;
        this.items = items;
    }

    public boolean isFull() {
        return items.size() >= size;
    }
}
