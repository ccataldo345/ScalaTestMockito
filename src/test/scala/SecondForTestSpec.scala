import org.mockito.Matchers.anyString
import org.mockito.Mockito.{atLeast, doReturn, spy, times, verify, when}
import org.scalatest.FlatSpec
import org.scalatestplus.mockito.MockitoSugar

import scala.util.Random

class SecondForTestSpec extends FlatSpec with MockitoSugar {

  val mockFistForTest: FirstForTest = mock[FirstForTest]
  val spySecondForTest: SecondForTest = spy(new SecondForTest(mockFistForTest))
  val c = "ok"

  behavior of "foo1"
  it should "ok" in {
    when(mockFistForTest.foo1(3)).thenReturn(22)
    val result = spySecondForTest.foo1(3)
    assertResult(25)(result)
  }

  behavior of "foo3"
  it should "invoke firstForTest.foo3 at least once" in {
    spySecondForTest.foo3()
    println("aaa= " + spySecondForTest.foo3())   // returns "ok"
    // println("bbb= " + mockFistForTest.foo3(Random.nextString(2)))   // returns null, why?
    // verify(mockFistForTest, atLeast(1)).foo3("ok")   // use to check what is the argument used in firstForTest.foo3 (random string of length 2)
    verify(mockFistForTest, atLeast(1)).foo3(anyString())
  }
}
