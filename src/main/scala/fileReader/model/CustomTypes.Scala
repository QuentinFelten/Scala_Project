/*package CustomTypes
import scala.util.matching.Regex

class NonEmptyString (val underlying: String) extends AnyVal

object NonEmptyString {
  def foo: NonEmptyString = new NonEmptyString(checkEmpty(NonEmptyString.underlying))

  def checkEmpty(arg: String){
    arg match {
      case None    => None
      case Some(arg) => arg.trim.isEmpty
    }
  }
}

class Code (val underlying: String) extends AnyVal

object Code {
  def foo: Code = new Code(checkCode(Code.underlying))

  def checkCode(arg: String){
    val pattern = new Regex("[A-Z][A-Z]")
    arg match{
      case pattern => arg
      case _       => None
    }
  }
}*/