import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.{doReturn, spy, when}
import org.scalatest.FlatSpec
import org.scalatestplus.mockito.MockitoSugar

class TestCSpec extends FlatSpec with MockitoSugar {

  val testC: TestC = spy(classOf[TestC])
  val configuration: Configuration = mock[Configuration]
  val userName: String = "mockedUserName"

  val builderA = mock[BuilderA]
  val provider = mock[Provider]

  val consumer = mock[Consumer]

  behavior of "foo1"
  it should "return Provider" in {

    val params = Array("", "")

    when(configuration.getParams).thenReturn(params)
    when(configuration.getUserName).thenReturn(userName)
    when(builderA.withParams(params)).thenReturn(builderA)
    when(builderA.withUserName(userName)).thenReturn(builderA)

    when(builderA.build()).thenReturn(provider)
    // 🡮 BUILDER Pattern magic: the method build() from the class BuilderA, is of type Provider,
    // therefore when called, the new builderA becomes of type Provider

    doReturn(builderA, Nil: _*).when(testC).foo1b()   // the method foo1b() is of type BuilderA
    val result = testC.foo1(configuration)    // calls the foo1() method, which calls the foo1b method, which has now the mocked builderA

    assertResult(provider)(result)    // compare the mocked provider with the foo1() method that had injected mocked builderA value
  }

  behavior of "foo2"
  it should "return 'hello back' when the parameter 'text' contains 'hello'" in {
    val result =  testC.foo2("test hello test good day")
    assertResult("hello back")(result)
  }

  it should "return 'it's evening' when the parameter 'text' contains 'good day' but doesn't contain 'hello'" in {
    val result = testC.foo2("test good day")
    assertResult("it's evening")(result)
  }

  it should "throw Exception when the parameter is neither of the above" in {
    assertThrows[Exception](testC.foo2("test test"))
  }

  behavior of "foo3"
  it should "return Consumer" in {
    val usernameCaptor: ArgumentCaptor[String] = ArgumentCaptor.forClass(classOf[String])
    val dataCaptor: ArgumentCaptor[Seq[String]] = ArgumentCaptor.forClass(classOf[Seq[String]])

    doReturn(consumer, Nil: _*).when(testC).getConsumer(usernameCaptor.capture(), dataCaptor.capture())
 
    val result = testC.foo3(userName)
    val data = dataCaptor.getValue
    assertResult(userName)(usernameCaptor.getValue)
    assertResult(3)(data.size)
    assertResult(1)(data(0).size)
    assertResult(2)(data(1).size)
    assertResult(3)(data(2).size)
    assertResult(consumer)(result)
  }

}