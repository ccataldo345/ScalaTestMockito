// abstract class TestC {
class TestC {
// object TestC extends App {

  // val token: String

  def foo1(configuration: Configuration): Provider = {
    new BuilderA().withParams(configuration.getParams).withUserName(configuration.getUserName).build()
  }

  def foo2(text: String): String = {
    if(text.contains("hello"))
      "hello back"
    else if (text.contains("good day"))
      "it's evening"
    else
      throw new Exception("unknown phrase")
  }

  def foo3(userName: String): Consumer = {
    import scala.util.Random
    val data = (1 to 3).map(i => Random.nextString(i))
    new Consumer(userName, data){}
  }

  // println(foo2("hello good day"))

}