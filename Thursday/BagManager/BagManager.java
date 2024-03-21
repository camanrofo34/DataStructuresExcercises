/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.BagManager;

import org.model.array.Array;
import org.model.priorityQueue.list.PriorityQueue;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class BagManager {
    private InventoryArray<BagPriorityQueue<ItemPile>> bag;

    public BagManager() {
        this.bag = new InventoryArray<>(4);
        bag.add(new BagPriorityQueue<>(5, 8));
    }
    
    public void addBag(int length){
        if (length == 8 || length == 12 || length == 14){
            bag.add(new BagPriorityQueue<>(5, length));
        }
    }
    
    public boolean addItem(Item item){
        for (int i=0; i<bag.size(); i++){
            BagPriorityQueue<ItemPile> actualBag = bag.get(i);
            if (actualBag.containsItem(item)){
                actualBag.changeItemQuantity(item);
                return true;
            }
            if (actualBag.ensureCapacity()){
                actualBag.insert(item.getPriority(), new ItemPile(item, 1));
                return true;
            }
        }
        return false;
    }
    
    public PriorityQueue<ItemPile> showItems(){
        PriorityQueue<ItemPile> itemsToDisplay = new PriorityQueue<>(5);
        Iterator<ItemPile> iterator;
        for(int i=0; i<bag.size(); i++){
            iterator = bag.get(i).iterator();
            while (iterator.hasNext()){
                ItemPile item = iterator.next();
                itemsToDisplay.insert(item.getPriority(), item);
            }
        }
        return itemsToDisplay;
    }
    
    public void exchangeItems (Item item1, Item item2){
        if (bag.contains(item1) != -1 && bag.contains(item2)!= -1){
            bag.exchangeItems(item1, item2);
        }
    }
    
    public void deleteBag(int indexBag){
        bag.remove(indexBag);
    }
    
    
}
