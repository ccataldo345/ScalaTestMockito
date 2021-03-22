class SecondForTest(firstForTest: FirstForTest) {

  def foo1(a: Int): Int = {
    firstForTest.foo1(a) + 3
  }

  def foo3(): String  = {
    import scala.util.Random
    firstForTest.foo3(Random.nextString(2))
    "ok"
  }

}
