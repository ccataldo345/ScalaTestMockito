import jdk.internal.org.jline.utils.InfoCmp.Capability
import org.mockito.Mockito
import org.mockito.Mockito.{CALLS_REAL_METHODS, spy}

class TestCSpec extends org.scalatest.FlatSpec {

  // val testC: TestC = ??? //todo:

  val testC: TestC = spy(new TestC)
  // val testC: TestC = Mockito.spy(TestC.class, Mockito.CALLS_REAL_METHODS)
  // val testC: TestC = spy(new TestC, CALLS_REAL_METHODS)

//  val configuration: Configuration = ??? // todo:
//  val userName: String = "mockedUserName"
//
//  behavior of "foo1"
//  it should "return Provider" in {
//    //todo..
//    val result = testC.foo1(configuration)
//    //todo..
//  }

  behavior of "foo2"
  it should "return 'hello back' when the parameter 'text' contains 'hello'" in {
    val result = testC.foo2("test hello test good day")
    assertResult("hello back")(result)
  }

  it should "return 'it's evening' when the parameter 'text' contains 'good day' but doesn't contain 'hello'" in {
    val result = testC.foo2(("test good day"))
    assertResult("it's evening")(result)
  }

  it should "throw Exception when the parameter is neither of the above" in {
    assertThrows[Exception](testC.foo2("test test"))
  }

//  behavior of "foo3"
//  it should "return Consumer" in {
//    //todo
//    val result = testC.foo3(userName)
//    //todo
//  }

}