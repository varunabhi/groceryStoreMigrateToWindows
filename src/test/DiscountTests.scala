//import com.varun.grocerystore.dao.{CatalogueDaoImpl, DiscountBuyGetDaoImpl, DiscountPercentDaoImpl}
//import com.varun.grocerystore.model.Item
//import com.varun.grocerystore.svc.CatalogueServices
//import com.varun.grocerystore.svc.DiscountServices.{BuyGetDiscount, PercentDiscount}
//import org.junit.runner.RunWith
//import org.scalatest.{BeforeAndAfter, FunSuite}
//import org.scalatest.junit.JUnitRunner
//
//@RunWith(classOf[JUnitRunner])
//class DiscountTests extends FunSuite with BeforeAndAfter{
//
//  val buyGetDao=new DiscountBuyGetDaoImpl
//  val buyGet= BuyGetDiscount(buyGetDao)
//
//  val percentDao=new DiscountPercentDaoImpl
//  val percent= PercentDiscount(percentDao)
//
//  val catalogdao= new CatalogueDaoImpl
//  val ctlgServ=CatalogueServices(catalogdao)
//  val items: List[Item] =ctlgServ.createCatalog().right.get
//
//  test("No Percentage Discount is applied"){
//    assert(percentDao.getAllDiscounts(items.head.id).get.isEmpty)
//  }
//
//  test("No BuyGet Discount is applied"){
//    assert(buyGetDao.getAllDiscounts(items.head.id).get.isEmpty)
//  }
//
//  test("Admin is able to set Percentage Discount"){
//    assert(percent.setDiscount(items.head.id,3,30).isRight)         // 30 % off on buying 3
//   }
//
//  test("Admin is able to set BuyGet Discount"){
//    assert(buyGet.setDiscount(items.head.id,3,items.last.id,2).isRight)         // Buy 3 pieces of item head and get 2 pieces of item last
//  }
//
//  test("Admin is able to get Percentage Discount"){
//    assert(percent.getDiscount(items.head.id).isRight)         // 30 % off on buying 3
//  }
//
//  test("Admin is able to get BuyGet Discount"){
//    assert(buyGet.getDiscount(items.head.id).isRight)         // Buy 3 pieces of item head and get 2 pieces of item last
//  }
//}
