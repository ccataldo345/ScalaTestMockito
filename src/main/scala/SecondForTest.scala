class SecondForTest(firstForTest: FirstForTest) {
  def foo1(a: Int): Int = {
    firstForTest.foo1(a) + 3
  }
}
