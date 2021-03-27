class TestCSpec extends org.scalatest.FlatSpec {
  val testC: TestC = ??? //todo:
  val configuration: Configuration = ??? // todo:
  val userName: String = "mockedUserName"

  behavior of "foo1"
  it should "return Provider" in {
    //todo..
    val result = testC.foo1(configuration)
    //todo..
  }

  behavior of "foo2"
  it should "return 'hello back' when .." in {
    //todo
  }
  it should "return 'it's evening' when .." in {
    //todo
  }
  it should "throw Exception when .." in {
    //todo
  }

  behavior of "foo3"
  it should "return Consumer" in {
    //todo
    val result = testC.foo3(userName)
    //todo
  }
}