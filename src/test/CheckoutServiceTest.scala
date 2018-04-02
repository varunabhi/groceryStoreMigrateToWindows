//package com.varun.grocerystore.services.CheckoutService
//
//import com.varun.grocerystore.dao._
//import com.varun.grocerystore.model.{Item, PaymentMethod}
//import com.varun.grocerystore.svc.DiscountServices.{BuyGetDiscount, PercentDiscount}
//import com.varun.grocerystore.svc.{CatalogueServices, CheckoutService, ModifiedCartService}
//import org.scalatest.{BeforeAndAfter, FunSuite}
//
//class CheckoutServiceTest extends FunSuite with BeforeAndAfter{
//
//  val cartDao=new CartModifiedDaoImpl
//  val chkoutSvc=CheckoutService(cartDao)
//  val ctlgDao=new CatalogueDaoImpl
//  val ctlgSvc=CatalogueServices(ctlgDao)
//  val cartSvc=ModifiedCartService(cartDao)
//  ctlgDao.getAllItems.get.foreach((x)=> cartSvc.addToCart(x.id,5))
//  val buyGetDao=new DiscountBuyGetDaoImpl
//
//  val buyGet= BuyGetDiscount(buyGetDao)
//  val percentDao=new DiscountPercentDaoImpl
//
//  val percent= PercentDiscount(percentDao)
//  val items: List[Item] =ctlgSvc.createCatalog().right.get
//
//  percent.setDiscount(items.head.id,3,20)
//  buyGet.setDiscount(items.last.id,3,items(1).id,2)
//
//  test("Final Total is Correct or not"){
//    val prices=cartSvc.getCart.values.map((x) => x.totalPrice)
//    assert(chkoutSvc.getCheckoutCart.getTotal===prices.sum)
//  }
//
//  test("Test Payment Method Service"){
//    chkoutSvc.setPaymentMethod(PaymentMethod.Net_Banking)
//    assert(chkoutSvc.getpaymentMethod === PaymentMethod.Net_Banking)
//  }
//
//  test("Test CheckoutCart and Current User Cart are not Same"){
//    assert(chkoutSvc.getCheckoutCart!=cartSvc.getCart)
//  }
//}
