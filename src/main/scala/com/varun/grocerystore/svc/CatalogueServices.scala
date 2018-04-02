package com.varun.grocerystore.svc

import java.io.File

import com.varun.grocerystore.dao.CatalogueDao
import com.varun.grocerystore.model.Item
import com.varun.grocerystore.utilities.XmlConverter

import scala.util.{Failure, Success}
import scala.xml.{NodeSeq, XML}

//SERVICES SHOULD NEVER BE CASE CLASSES
class CatalogueServices(catalogueDao:CatalogueDao) {
  private val f = XML.loadFile(new File("/home/varun/IdeaProjects/grocerystore[Unit]/src/main/scala/com/varun/grocerystore/GroceryDataBasic.xml"))
  private val tag: NodeSeq = f \\ "item"


  def getTagLength: Int = {  //only for testing purpose
    tag.length
  }

    def updateCatalogue(): List[Item] = {                  // Run It in Main Once to Start Service
      (new CatalogueUpdateService).updateCatalogue(createCatalog().right.get)
    }


  def addItem(item:Item): Either[Throwable,Item] ={
    catalogueDao.insertItem(item)
    catalogueDao.findItem(item.id) match {
      case Success(a) => Right(a)
      case Failure(b) => Left(b)
    }
  }


  def createCatalog(): Either[Throwable,List[Item]] = {  // To be Run Firstly
    val lst_items=tag.map(XmlConverter.toItemXML).toList
    lst_items.foreach(catalogueDao.insertItem)
    val catalogueTemp=catalogueDao.getAllItems match
    {
      case Success(a) => Right(a)
      case Failure(b) => Left(b)
    }
    catalogueTemp
  }

}








