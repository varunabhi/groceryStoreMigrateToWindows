package com.varun.grocerystore.svc.DiscountServices

import com.varun.grocerystore.dao.DiscountBuyGetDao

import scala.util.{Failure, Success}

class BuyGetDiscount( discountBuyGetDao: DiscountBuyGetDao) {

  def setDiscount(itemId: Int, itemQty: Double, offerItemId: Int, offerItemQty: Double): Either[Throwable,Map[Int,Map[Double, List[(Int, Double)]]]] ={
    discountBuyGetDao.addDiscount(itemId,itemQty,offerItemId,offerItemQty) match {
      case Success(s) => Right(s)
      case Failure(f) => Left(f)
    }
  }


  def getDiscount(itemId:Int): Either[Throwable,Map[Double,List[(Int,Double)]]] ={
    discountBuyGetDao.getAllDiscounts(itemId) match {
      case Success(s) => println("Success");Right(s)
      case Failure(f) => println("Failure");Left(f)
    }
  }
}
