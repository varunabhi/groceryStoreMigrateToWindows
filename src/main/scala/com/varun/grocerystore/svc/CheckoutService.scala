package com.varun.grocerystore.svc

import com.varun.grocerystore.dao.CartModifiedDao
import com.varun.grocerystore.model.WrapperClasses.ItemInCartDetails
import com.varun.grocerystore.model.{Cart_Modified, PaymentMethod}

import scala.collection.immutable
import scala.util.Try

class CheckoutService(cartModifiedDao: CartModifiedDao) {

  var paymentMthd:PaymentMethod.Value=_


  def getCheckoutCart: Cart_Modified ={
    val cart=Cart_Modified(new ModifiedCartService(cartModifiedDao).getCart)
    cart
  }


  def getFinalTotal:Double={
    val cart=Cart_Modified(cartModifiedDao.getCart.get)
    cart.getTotal
  }

  def setPaymentMethod(mthd:PaymentMethod.Value): Try[PaymentMethod.Value] ={
    paymentMthd=mthd
    Try(checkPayment(paymentMthd))
  }

  def checkPayment(obj:PaymentMethod.Value): PaymentMethod.Value ={
    if(obj==getpaymentMethod)
      obj
    else
      throw new Exception("Payment Method error")
  }

  def getpaymentMethod: PaymentMethod.Value ={
    paymentMthd
  }

  def finalDiscountedPercentCart(): Map[Int,ItemInCartDetails] ={
    val cart=getCheckoutCart.getCart
    val discountedCart=cart.map((x) => applyDiscount(x._2))
    discountedCart
  }


  var extras: Map[Int, List[(Int, Double)]] = immutable.Map[Int,List[(Int,Double)]]()

  private def applyDiscount(itemInCartDetails: ItemInCartDetails): (Int,ItemInCartDetails) ={
    val item=itemInCartDetails.itemId
    if(itemInCartDetails.percDiscount != 0.0){val NewsubPrice=itemInCartDetails.totalPrice-(itemInCartDetails.totalPrice*(itemInCartDetails.percDiscount/100))
      item->ItemInCartDetails(item,itemInCartDetails.currentQty,NewsubPrice,itemInCartDetails.percDiscount,itemInCartDetails.BuyGetDisc)}
    else if(itemInCartDetails.BuyGetDisc._1 != -1){extras+=(item -> List(itemInCartDetails.BuyGetDisc))
    item->itemInCartDetails}
    else item->itemInCartDetails
  }
}

