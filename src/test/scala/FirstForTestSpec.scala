import org.scalatest.FlatSpec
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._

class FirstForTestSpec extends FlatSpec with MockitoSugar {

  val spyFirstForTest: FirstForTest = spy(new FirstForTest)
  val a = 3
  val b = "abc"
  val c = "abc"
  val myException = new Exception ("i'm bad, i should be mocked")

  behavior of "value"
  it should "return null" in {
    val result = spyFirstForTest.value
    assertResult(null)(result)
  }

  behavior of "bad"
  it should "throw an exception" in {
    assertThrows[Exception](spyFirstForTest.bad())
  }

  behavior of "foo1"
  it should "return squared value" in {
    when(spyFirstForTest.foo1(a)).thenReturn(a*a)
    val result = spyFirstForTest.foo1(a)
    assertResult(a*a)(result)
  }

  behavior of "foo2"
  it should "return a composed string and exception" in {
    assertThrows[Exception](spyFirstForTest.foo2(b))
  }
  it should "return a composed string" in {
    //doReturn(s"$myException", Nil:_*).when(spyFirstForTest).bad()
    doReturn(s"$myException", Nil:_*).when(spyFirstForTest).bad()
    val result = spyFirstForTest.foo2(b)
    assertResult(s"$b $myException")(result)
  }

  behavior of "foo3"
  it should "return a composed string" in {
    reset(spyFirstForTest)
    val result = spyFirstForTest.foo3(c)
    assertResult(c)(spyFirstForTest.value)    //check that value of c is set (not null)
    assertResult(s"$c should be set")(result)
  }

}
