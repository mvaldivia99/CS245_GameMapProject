package com.example.fe.inventory;

import java.util.ArrayList;

/*
*
* Convoy: collective inventory between player units
*
* During in-game only the player unit will be able to access the Convoy.
* Convoy stores all items.
* */
public class Convoy {
    ArrayList<Item> items;

    Convoy(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public Item getItem(int index){
        return items.get(index);
    }

    // user would like to get an item by its name
    // issue: multiple items by the same name
    public ArrayList<Item> getItem(String name) throws Exception{

        // Sort our list
        items.sort(new Item.ItemComparable());

        // O(n)
        ArrayList<Item> returnList = new ArrayList<>();

        for (Item item : items){
            if (item.getName().equals(name)){
                returnList.add(item);
            }
        }

        if  (returnList.isEmpty()){
            throw new Exception("Item not found");
        }

        return returnList;

    }


















}
