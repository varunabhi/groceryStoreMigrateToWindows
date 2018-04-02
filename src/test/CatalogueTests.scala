//package com.varun.grocerystore.services.CatalogueServices
//
//import com.varun.grocerystore.dao.CatalogueDaoImpl
//import com.varun.grocerystore.model.Item
//import com.varun.grocerystore.svc.CatalogueServices
//import org.junit.runner.RunWith
//import org.mockito.Mockito._
//import org.scalatest.FunSuite
//import org.scalatest.junit.JUnitRunner
//
//@RunWith(classOf[JUnitRunner])
//class CatalogueTests extends FunSuite {
//
////  val ctlgDao=new CatalogueDaoImpl
//  val ctlgDao: CatalogueDaoImpl =mock(classOf[CatalogueDaoImpl])
//  val ctlgSvc = new CatalogueServices(ctlgDao)
////
////  before{
////    ctlgDao.clearAllItems()
////    ctlgSvc.createCatalog()
////  }
//
//
//  test("Tag read is not Empty") {
//    assert(ctlgSvc.getTagLength!=0)
//  }
//
//  test("Items are being added to Catalogue") {
////    when(ctlgDao.getAllItems.get).thenReturn(List(Item(1,"Apple",120,100,1)))
////    val items=ctlgDao.getAllItems.get
//    //    println("Items size "+items.size)
////    when(ctlgDao.insertItem(Item))
//    assert(ctlgSvc.addItem(items.head).isRight)
//  }
//
//  test("Catalogue is being created or not"){
//    assert(ctlgSvc.createCatalog().isRight)     // We have to call create catalog Functions as well or not
//  }
//
//
//  test("All items are stored in Catalogue") {
//    when(ctlgDao.getAllItems.get.size).thenReturn(7)
//    assert(ctlgDao.getAllItems.get.size===ctlgSvc.getTagLength)
//  }
//}
//
