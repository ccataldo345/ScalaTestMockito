class FirstForTest {

    var value: String = null
    def bad(): String = {
      throw new Exception("i'm bad, i should be mocked")
    }
    def foo1(a: Int): Int = {
      a*a
    }
    def foo2(b: String): String = {
      s"$b ${bad()}"
    }
    def foo3(c: String): String = {
      this.value = c
      s"$c should be set"
    }

}