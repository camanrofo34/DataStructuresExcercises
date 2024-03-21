/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.BagManager;

/**
 *
 * @author PC 4060TI
 */
public class Item {
    private String itemName;
    private int priority;
    private int rank;
    private Type type;
    private int durability;
    private String description;
    
    private enum Type { CLOTH, LEATHER, PLATE }

    public Item(String itemName, int priority, int rank, Type type, int durability, String description) {
        this.itemName = itemName;
        this.priority = priority;
        this.rank = rank;
        this.type = type;
        this.durability = durability;
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
