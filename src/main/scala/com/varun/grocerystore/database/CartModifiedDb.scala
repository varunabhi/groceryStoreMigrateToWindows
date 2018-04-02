package com.varun.grocerystore.database

import com.varun.grocerystore.model.WrapperClasses.{ItemInCartDetails}

import scala.collection.mutable

object CartModifiedDb {

  val cart: mutable.HashMap[Int, ItemInCartDetails] =mutable.HashMap[Int,ItemInCartDetails]()

  def addToDb(itemId:Int,itemDetails:ItemInCartDetails): mutable.HashMap[Int, ItemInCartDetails] ={
    cart.put(itemId ,itemDetails)
    cart
  }

  def getDb: mutable.HashMap[Int, ItemInCartDetails] ={
    cart
  }

  def findItem(itemId:Int): ItemInCartDetails ={
    cart(itemId)
  }

  def removeFromDb(itemId:Int): mutable.HashMap[Int, ItemInCartDetails] ={
    cart.remove(itemId)
    cart
  }

  def updateDb(itemId:Int,itemDetails:ItemInCartDetails): mutable.HashMap[Int, ItemInCartDetails] ={
    cart.update(itemId,itemDetails)
    cart
  }

  def clearDb(): mutable.HashMap[Int, ItemInCartDetails] ={
    cart.clear()
    cart
  }


}
