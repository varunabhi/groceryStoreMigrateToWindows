package com.varun.grocerystore.dao
import com.varun.grocerystore.database.DiscountBuyGetDb
import com.varun.grocerystore.exceptions.ParsingException

import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.util.Try

class DiscountBuyGetDaoImpl extends DiscountBuyGetDao {
  override def getAllDiscounts(itemId: Int): Try[Map[Double, List[(Int, Double)]]] = {
        val discounts=DiscountBuyGetDb.getDiscounts(itemId)
          println("Here size is "+discounts.size)
          Try(discounts match {
            case a:Map[Double, List[(Int, Double)]] => HashMap() ++ discounts
            case _ => throw ParsingException(s"Unable to get Discounts for Item with Id $itemId ")
          })
  }

  override def addDiscount(itemId: Int, itemQty: Double, offerItemId: Int, offerItemQty: Double): Try[Map[Int,Map[Double, List[(Int, Double)]]]] = {
    val updatedDb=DiscountBuyGetDb.addToDb(itemId,itemQty,offerItemId,offerItemQty)
    Try( updatedDb match {
      case a:mutable.Map[Int,Map[Double, List[(Int, Double)]]] => HashMap() ++ updatedDb
      case _ => throw ParsingException(s"Not able to add item discount of Item with id $itemId")
    })
  }
}
