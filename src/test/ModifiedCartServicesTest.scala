//import com.varun.grocerystore.dao.{CartModifiedDao, CatalogueDaoImpl}
//import com.varun.grocerystore.model.{Cart_Modified, Item}
//import com.varun.grocerystore.model.WrapperClasses.ItemInCartDetails
//import com.varun.grocerystore.svc.{CatalogueServices, ModifiedCartService}
//import org.junit.runner.RunWith
//import org.scalatest.junit.JUnitRunner
//import org.scalatest.{BeforeAndAfter, FunSuite}
//import org.mockito.{Mockito, mock}
//
//import scala.util.Success
//
//@RunWith(classOf[JUnitRunner])
//class ModifiedCartServicesTest extends FunSuite with BeforeAndAfter{
//
//  val cartDao= Mockito.mock(Catalo)
//  //val cartDao=new CartModifiedDaoImpl
//  val ctlgDao=new CatalogueDaoImpl
//  val cartSvc=ModifiedCartService(cartDao)
//  val ctlgSvc=CatalogueServices(ctlgDao)
//  var items:List[Item]=Nil
//  before{
//    cartDao = mock(cartDao)
//    ctlgDao.clearAllItems()
//    ctlgSvc.createCatalog()
//    items=ctlgDao.getAllItems.get
//  }
//
//  test("Test whether Items are getting added or not") {
//    when(cartDao.insertItem(anyInt(), any[ItemInCartDetails])).thenReturn(Success(ItemWra))
//    assert(cartSvc.addToCart(items.head.id, 5).isRight)
//  }
//
//  test("All are added to cart or not"){
//    items.foreach((x) => cartSvc.addToCart(x.id,5))
//    assert(cartDao.getCurrentCount===ctlgDao.getCurrentCount)
//  }
//
//  test("Cart is updated or not"){
//    cartSvc.updateCart(items.head.id,9)
//    assert(cartDao.findItem(items.head.id).get.currentQty===9)
//  }
//
//  test("Item is getting removed"){
//    cartSvc.removeFromCart(items.head.id).isRight
////    assert(cartSvc.getItemFromCart(items.head.id).isLeft)
//  }
//
//  test("Cart is clear"){
//    assert(cartSvc.clearCart().isRight)
//  }
//
//}
