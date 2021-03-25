import scala.util.matching.Regex

object RegexUtils extends App {
  implicit class RichRegex(val underlying: Regex) extends AnyVal {
    def matches(s: String) = underlying.pattern.matcher(s).matches

  }

  val digit: Regex = """\d""".r
  if (digit matches "5") println("match")
  else println("no match")
}