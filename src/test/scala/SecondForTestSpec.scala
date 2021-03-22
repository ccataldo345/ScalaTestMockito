import org.mockito.Mockito.{spy, when}
import org.scalatest.FlatSpec
import org.scalatestplus.mockito.MockitoSugar

class SecondForTestSpec extends FlatSpec with MockitoSugar {

  val mockFistForTest: FirstForTest = mock[FirstForTest]
  val spySecondForTest: SecondForTest = spy(new SecondForTest(mockFistForTest))

  behavior of "foo1"
  it should "ok" in {
    when(mockFistForTest.foo1(3)).thenReturn(22)
    val result = spySecondForTest.foo1(3)
    assertResult(25)(result)
  }
}
