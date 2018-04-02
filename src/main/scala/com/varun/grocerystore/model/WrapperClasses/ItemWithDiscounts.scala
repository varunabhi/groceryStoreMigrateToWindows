package com.varun.grocerystore.model.WrapperClasses

import scala.collection.immutable.HashMap

case class ItemWithDiscounts(itemId:Int, percentDiscMap:HashMap[Double,Double], buyGetDiscMap:Map[Double,List[(Int,Double)]])
