package com.varun.grocerystore.svc

import com.varun.grocerystore.dao._
import com.varun.grocerystore.model.WrapperClasses.ItemInCartDetails

import scala.util.{Failure, Success}

class ModifiedCartService(cartModifiedDao: CartModifiedDao,discountPercentDao: DiscountPercentDao= new DiscountPercentDaoImpl,discountBuyGetDao: DiscountBuyGetDao=new DiscountBuyGetDaoImpl,catalogueDao: CatalogueDao=new CatalogueDaoImpl) {

    def getItemFromCart(itemId: Int): Either[Throwable,ItemInCartDetails] ={
      val itemDetails=cartModifiedDao.findItem(itemId) match {
        case Success(a) => Right(a)
        case Failure(b) => Left(b)
      }
      itemDetails
    }


    def addToCart(itemId:Int, qty:Double):Either[Throwable,Map[Int,ItemInCartDetails]] ={
      val itemDetails=discountUtility(itemId,qty)
      val updatedCart=cartModifiedDao.insertItem(itemId,itemDetails) match {
        case Success(s) => Right(s)
        case Failure(f) => Left(f)
      }
      updatedCart
    }


      def getCart: Map[Int,ItemInCartDetails] ={
        cartModifiedDao.getCart.get
      }

      def updateCart(itemId:Int,newQty:Double): Either[Throwable,Map[Int,ItemInCartDetails]]={
          val itemDetails=discountUtility(itemId,newQty)
        val updatedCart=cartModifiedDao.updateItem(itemId,itemDetails) match {
          case Success(s) => Right(s)
          case Failure(f) => Left(f)
        }
        updatedCart
      }


      def removeFromCart(itemId:Int): Either[Throwable,Map[Int,ItemInCartDetails]] ={
        val updatedCart=cartModifiedDao.deleteItem(itemId) match {
          case Success(s) => Right(s)
          case Failure(f) => Left(f)
        }
        updatedCart
      }


      def clearCart(): Either[Throwable,Map[Int,ItemInCartDetails]] ={
        val updatedCart=cartModifiedDao.clearAllItems() match {
          case Success(s) => Right(s)
          case Failure(f) => Left(f)
        }
        updatedCart
      }

    private def discountUtility(itemId:Int,qty:Double): ItemInCartDetails = {
    val TotalPrice = catalogueDao.findItem(itemId).get.amount * qty
      var PercDiscount=0.0
      try{
        PercDiscount = discountPercentDao.getAllDiscounts(itemId).get.get(qty) match {
      case Some(x) => x
      case None => 0.0
    }}
      catch {
        case ex:NoSuchElementException=>PercDiscount=0.0
      }

      var BGDisc=(-1,0.0)
      try{
        BGDisc = discountBuyGetDao.getAllDiscounts(itemId).get.get(qty) match {
      case Some(x) => x.head
      case None => (-1, 0.0)
    }}
      catch {
        case ex:NoSuchElementException=>BGDisc=(-1,0.0)
      }


    ItemInCartDetails(itemId, qty, TotalPrice, PercDiscount, (BGDisc._1,BGDisc._2.toDouble))
  }

}
