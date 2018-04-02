package com.varun.grocerystore.model


case class Item(id: Int, name: String, amount: Double, stock: Double, discPerc : Double=0) extends Serializable



