package com.varun.grocerystore.svc.DiscountServices

import com.varun.grocerystore.dao.{DiscountBuyGetDao, DiscountPercentDao}
import com.varun.grocerystore.model.WrapperClasses.ItemWithDiscounts

class ItemDiscountServices(discountPercentDao: DiscountPercentDao,discountBuyGetDao: DiscountBuyGetDao)  {

  //Wrapper Class to Bind Item with It's All Available Discounts
  def getAllDiscounts(itemId:Int): ItemWithDiscounts ={
    val percentDisc=new PercentDiscount(discountPercentDao).getDiscount(itemId)
    val buyGetDisc=new BuyGetDiscount(discountBuyGetDao).getDiscount(itemId)
    ItemWithDiscounts(itemId,percentDisc.right.get,buyGetDisc.right.get)
  }
}
