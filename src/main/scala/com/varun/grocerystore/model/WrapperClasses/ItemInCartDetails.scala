package com.varun.grocerystore.model.WrapperClasses

case class ItemInCartDetails(itemId:Int, currentQty:Double, totalPrice:Double, percDiscount:Double=0.0 , BuyGetDisc:(Int,Double)=(-1,0))
