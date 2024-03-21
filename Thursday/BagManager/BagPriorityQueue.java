/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.BagManager;

import org.model.priorityQueue.list.PriorityQueue;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 * @param <E>
 */
public class BagPriorityQueue<E extends ItemPile> extends PriorityQueue<E>{
    private int capacidad;
    public BagPriorityQueue(int n, int capacidad) {
        super(n);
        this.capacidad = capacidad;
    }
    
    public boolean containsItem(Item item){
        Iterator<E> iterator = this.iterator();
        while(iterator.hasNext()){
            Item itemGot = iterator.next().getItem();
            if (itemGot.equals(item)){
                return true;
            }
        }
        return false;
    }
    
    public boolean ensureCapacity(){
        return this.size()!= capacidad;
    }
    
    public void changeItemQuantity(Item item){
        Iterator<E> iterator = this.iterator();
        while(iterator.hasNext()){
            ItemPile itemPileGot = iterator.next();
            Item itemGot = itemPileGot.getItem();
            if (itemGot.equals(item)){
                itemPileGot.addAmount();
            }
        }
    }
    
}
