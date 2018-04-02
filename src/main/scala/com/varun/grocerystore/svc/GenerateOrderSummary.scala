package com.varun.grocerystore.svc

import com.varun.grocerystore.dao.CartModifiedDao
import com.varun.grocerystore.model.{Cart, Cart_Modified, PaymentMethod}

class GenerateOrderSummary(cartModifiedDao: CartModifiedDao) {

  def showFinalCart(): Cart_Modified ={
    val cart=Cart_Modified(new ModifiedCartService(cartModifiedDao).getCart)
    cart
  }

  def showFinalTotal(obj1:Cart): Double ={
    showFinalCart().getTotal
  }

  def getPaymentMethod(obj:CheckoutService): PaymentMethod.Value ={
    obj.getpaymentMethod
  }
}