class BuilderA{

  private var params: Array[String] = _
  private var userName: String = _

  def build(): Provider  = ???    // do not need to implement!

  def withParams(params: Array[String]): BuilderA = {
    this.params = params
    this
  }
  def withUserName(userName: String): BuilderA = {
    this.userName = userName
    this
  }
}