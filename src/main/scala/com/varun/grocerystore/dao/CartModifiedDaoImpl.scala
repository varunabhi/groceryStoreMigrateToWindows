package com.varun.grocerystore.dao

import com.varun.grocerystore.database.CartModifiedDb
import com.varun.grocerystore.exceptions.{ItemNotFoundException, ParsingException}
import com.varun.grocerystore.model.WrapperClasses.ItemInCartDetails

import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.util.Try

class CartModifiedDaoImpl extends CartModifiedDao {
  override def findItem(itemId: Int): Try[ItemInCartDetails] = {
    val itemDetails=CartModifiedDb.findItem(itemId)
    Try(itemDetails match {
      case _:ItemInCartDetails => itemDetails
      case _ => throw new ItemNotFoundException()
    })
  }

  override def getCart: Try[Map[Int, ItemInCartDetails]] = {
    val cart=CartModifiedDb.getDb
    Try(cart match {
      case _:mutable.HashMap[Int, ItemInCartDetails] => HashMap() ++ cart
      case _ => throw new ParsingException()
    })
  }

  override def insertItem(itemId: Int, itemDetails: ItemInCartDetails): Try[Map[Int, ItemInCartDetails]] = {
    val updatedCart=CartModifiedDb.addToDb(itemId,itemDetails)
    Try(updatedCart match {
      case _:mutable.HashMap[Int, ItemInCartDetails] => HashMap() ++ updatedCart
      case _ => throw new ParsingException()
    })
  }

  override def updateItem(itemId: Int, itemDetails: ItemInCartDetails): Try[Map[Int, ItemInCartDetails]] = {
    val updatedCart=CartModifiedDb.updateDb(itemId,itemDetails)
    Try(updatedCart match {
      case _:mutable.HashMap[Int, ItemInCartDetails] => HashMap() ++ updatedCart
      case _ => throw new ParsingException()
    })
  }

  override def deleteItem(itemId: Int): Try[Map[Int, ItemInCartDetails]] = {
    val updatedCart=CartModifiedDb.removeFromDb(itemId)
    Try(updatedCart match {
      case _:mutable.HashMap[Int, ItemInCartDetails] => HashMap() ++ updatedCart
      case _ => throw new ParsingException()
    })
  }

  override def clearAllItems(): Try[Map[Int, ItemInCartDetails]] = {
    val updatedCart=CartModifiedDb.clearDb()
    Try(updatedCart match {
      case _:mutable.HashMap[Int, ItemInCartDetails] =>  HashMap() ++ updatedCart
      case _ => throw new ParsingException()
    })
  }

  override def getCurrentCount: Int = {
    CartModifiedDb.getDb.size
  }
}
