package com.varun.grocerystore.dao

import scala.collection.immutable._
import scala.util.Try

trait DiscountBuyGetDao {
    def getAllDiscounts(itemId:Int):Try[Map[Double,List[(Int,Double)]]]
    def addDiscount(itemId:Int,itemQty:Double,offerItemId:Int,offerItemQty:Double):Try[Map[Int,Map[Double, List[(Int,Double)]]]]
}
