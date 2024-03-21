/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.BagManager;

/**
 *
 * @author PC 4060TI
 */
public class ItemPile {
    private Item item;
    private int amount;

    public ItemPile(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public ItemPile(Item item) {
        this.item = item;
        this.amount=1;
    }
    
    
    public int getPriority() {
        return item.getPriority();
    }
    

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void addAmount (){
        this.amount++;
    }
    
    
}
