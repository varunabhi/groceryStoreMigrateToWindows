package com.varun.grocerystore.svc

import com.varun.grocerystore.dao.{CartModifiedDao, CatalogueDao}
import com.varun.grocerystore.model.Item

import scala.util.{Failure, Success}

class PostCheckoutCatalogUpdate(catalogDao:CatalogueDao) {


  private def updateItem(itemId: Int,qty:Double): Unit ={
    val itemTemp=catalogDao.findItem(itemId).get
    catalogDao.deleteItem(itemTemp)

    catalogDao.insertItem(Item(itemTemp.id,itemTemp.name,itemTemp.amount,itemTemp.stock-qty))
  }

  def updatedCatalog(cart:CartModifiedDao ): Either[Throwable,List[Item]] ={
    val crt=cart.getCart.get
    crt.foreach((x) => updateItem(x._1,x._2.currentQty))
    val updatedCtlg=catalogDao.getAllItems match {
      case Success(s) => Right(s)
      case Failure(f) => Left(f)
    }
    updatedCtlg
  }
}