package com.varun.grocerystore.dao

import com.varun.grocerystore.model.WrapperClasses.{ItemInCartDetails}

import scala.util.Try

trait CartModifiedDao {
  def findItem(itemId:Int):Try[ItemInCartDetails]
  def getCart:Try[Map[Int,ItemInCartDetails]]
  def insertItem(itemId:Int,itemDetails:ItemInCartDetails):Try[Map[Int,ItemInCartDetails]]
  def updateItem(itemId:Int,itemDetails:ItemInCartDetails):Try[Map[Int,ItemInCartDetails]]
  def deleteItem(itemId:Int):Try[Map[Int,ItemInCartDetails]]
  def clearAllItems():Try[Map[Int,ItemInCartDetails]]
  def getCurrentCount:Int
}
