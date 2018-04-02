//package com.varun.grocerystore.services.com.varun.grocerystore.services.PostCheckoutCatalogUpdateTest
//
//import com.varun.grocerystore.dao.{CartModifiedDaoImpl, CatalogueDaoImpl}
//import com.varun.grocerystore.model.Item
//import com.varun.grocerystore.svc.{CatalogueServices, ModifiedCartService, PostCheckoutCatalogUpdate}
//import org.scalatest.{BeforeAndAfter, FunSuite}
//
//class PostCheckoutCatalogUpdateTest extends FunSuite with BeforeAndAfter{
//
//  val ctlgDao= new CatalogueDaoImpl
//  val ctlgSvc= CatalogueServices(ctlgDao)
//  val cartDao= new CartModifiedDaoImpl
//  val cartSvc= ModifiedCartService(cartDao)
//  ctlgSvc.createCatalog()
//  val items: List[Item] =ctlgDao.getAllItems.get
//  items.foreach((x) => cartSvc.addToCart(x.id,7))
//
//  test("After Consuming items, Same is reflected in Stock as well"){
//    val oldCatalogSize=ctlgDao.findItem(1).get.stock
//    val postUpdate= PostCheckoutCatalogUpdate(ctlgDao)
//    val updatedCtlg=postUpdate.updatedCatalog(cartDao).right.get
//    assert(oldCatalogSize===updatedCtlg.find(_.id==1).get.stock+7)
//  }
//
//
//}
