abstract class TestC {
// object TestC extends App {

  val token: String

  def foo1(configuration: Configuration): Provider = {
    foo1b.withParams(configuration.getParams).withUserName(configuration.getUserName).build()
  }

  def foo1b(): BuilderA = {
    new BuilderA()
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
    println(data)
    //new Consumer(userName, data){}
    getConsumer(userName, data)

  }

  def getConsumer(userName: String, data: Seq[String]): Consumer = {
    new Consumer(userName, data){}
  }

//  // println(foo2("hello good day"))
//  def getConsumer: Consumer = foo3("aaa")
 // println(foo3("aa"))
//  println(getConsumer)
//  // println(foo3("aaa").consumer2)

}