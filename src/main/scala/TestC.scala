abstract class TestC {

  val token: String

  /* initial def foo1(), then transformed into 2 methods:
  def foo1(configuration: Configuration): Provider = {
    new BuilderA().withParams(configuration.getParams).withUserName(configuration.getUserName).build()
  }*/

  def foo1(configuration: Configuration): Provider = {
    foo1b().withParams(configuration.getParams).withUserName(configuration.getUserName).build()
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
    val data = (1 to 3).map(i => Random.nextString(i))    // it returns: Vector(A, AB, ABC) => 3 elements of length 1 to 3
    // println(data)
    //new Consumer(userName, data){}    // inline object, to be transformed into method def getConsumer(userName, data)
    getConsumer(userName, data)

  }

  def getConsumer(userName: String, data: Seq[String]): Consumer = {
    new Consumer(userName, data){}
  }

}