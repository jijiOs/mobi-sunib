package com.example.voter2

import java.util.ArrayList

class Item (
    var id: String,
    var name: String,
    var value: String
)
object ItemController{

    private val itemList = ArrayList<Item>()

    fun addItem (itemData: Item) {
        itemList.add(itemData)
    }

    fun getItems(): List<Item> {
        return itemList
    }
}