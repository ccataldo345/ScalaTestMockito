class BuilderA{

  private var params: Array[String] = _
  private var userName: String = _

  def build(): Provider  = ???

  def withParams(params: Array[String]) = {
    this.params = params
    this
  }
  def withUserName(userName: String) = {
    this.userName = userName
    this
  }
}