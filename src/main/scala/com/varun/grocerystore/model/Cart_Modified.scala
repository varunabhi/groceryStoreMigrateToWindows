package com.varun.grocerystore.model

import com.varun.grocerystore.model.WrapperClasses.ItemInCartDetails

case class Cart_Modified(map: Map[Int,ItemInCartDetails]){

  def getCart: Map[Int,ItemInCartDetails] ={
    map
  }

  def getCurrentCount: Int ={
    map.size
  }

  def getTotal:Double={
    val allPrices=map.values.toList.map((x) =>x.totalPrice)
    allPrices.sum
  }
}
