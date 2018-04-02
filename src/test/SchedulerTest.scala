//import java.util.Calendar
//
//import com.varun.grocerystore.dao.CatalogueDaoImpl
//import com.varun.grocerystore.model.Item
//import com.varun.grocerystore.svc.{CatalogueServices, CatalogueUpdateService}
//import org.junit.runner.RunWith
//import org.scalatest.{FunSuite, _}
//import org.scalatest.junit.JUnitRunner
//
//
//@RunWith(classOf[JUnitRunner])
//class SchedulerTest extends FunSuite with BeforeAndAfter {
//
//
//  val ctlgDao=new CatalogueDaoImpl
//  val obj_ctlgServ=CatalogueServices(ctlgDao)
//  val obj_updCtl=new CatalogueUpdateService
//    val lst_items: List[Item] =obj_ctlgServ.createCatalog().right.get
//  val hour: Int =Calendar.HOUR_OF_DAY
//
//  test("To test update service"){
//    val init_len=obj_ctlgServ.createCatalog().right.get.size
//    Thread.sleep(15000)
//    val post_length=obj_ctlgServ.updateCatalogue().length
//    assert(init_len!=post_length)
//  }
//}
