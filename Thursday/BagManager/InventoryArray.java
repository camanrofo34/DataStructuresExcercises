/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.BagManager;

import org.model.LinkedList.singly.LinkedList;
import org.model.array.Array;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 * @param <E>
 */
public class InventoryArray<E extends BagPriorityQueue> extends Array<E> {

    public InventoryArray(int dimension) {
        super(dimension);
    }

    public int contains(Item item) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).containsItem(item)) {
                index = i;
            }
        }
        return index;
    }

    public void exchangeItems(Item item1, Item item2) {
        LinkedList<ItemPile> items1 = new LinkedList<>();
        LinkedList<ItemPile> items2 = new LinkedList<>();
        ItemPile itemPile1 = null;
        ItemPile itemPile2 = null;
        int index1 = contains(item1);
        int index2 = contains(item1);
        BagPriorityQueue bag1 = this.get(index1);
        for (int i = 0; i < bag1.size(); i++) {
            ItemPile item = (ItemPile) bag1.extract();
            if (!item.getItem().equals(item1)) {
                items1.add(item);
            } else {
                itemPile1 = item;
            }
        }
        BagPriorityQueue bag2 = this.get(index2);
        for (int i = 0; i < bag2.size(); i++) {
            ItemPile item = (ItemPile) bag2.extract();
            if (!item.getItem().equals(item1)) {
                items2.add(item);
            } else {
                itemPile2 = item;
            }
        }
        items1.add(itemPile2);
        items2.add(itemPile1);
        Iterator<ItemPile> iterator1 = items1.iterator();
        Iterator<ItemPile> iterator2 = items2.iterator();
        while (iterator1.hasNext()) {
            ItemPile itemToPile1 = iterator1.next();
            bag1.insert(itemToPile1.getPriority(), itemToPile1);
        }
        while (iterator2.hasNext()) {
            ItemPile itemToPile2 = iterator2.next();
            bag1.insert(itemToPile2.getPriority(), itemToPile2);
        }

    }
}
