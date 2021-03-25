import java.util.regex.Pattern

object MyRegex extends App {

  val mockUuidReferer: String = "5e4b9f58475e4222b871de442b34df27"
  // https://stackoverflow.com/questions/3436118/is-java-regex-case-insensitive
  // val regexUuidReferer = Pattern.compile("[0-9A-F]{8}[0-9A-F]{4}4[0-9A-F]{3}[89AB][0-9A-F]{3}[0-9A-F]{12}", Pattern.CASE_INSENSITIVE)
  val regexUuidReferer = Pattern.compile("($i)[0-9A-F]{8}[0-9A-F]{4}4[0-9A-F]{3}[89AB][0-9A-F]{3}[0-9A-F]{12}")
  val matcher = regexUuidReferer.matcher(mockUuidReferer)
  val result = matcher.matches()
  println(mockUuidReferer)
  println(regexUuidReferer)
  println(matcher)
  println(result)

}
