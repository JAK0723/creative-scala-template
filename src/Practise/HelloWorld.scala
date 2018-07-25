import scala.annotation.tailrec

object HelloWorld extends App {
  //  println("Hello, World!")

  //  val add = (x: Int, y: Int) => x + y

  def count(from: Int, to: Int): Int = {
    var result = from
    while (result < to) {
      result += 1
    }
    result
  }

  @tailrec def countRec(from: Int, to: Int): Int = {
    if (from >= to) {
      from
    } else {
      countRec(from + 1, to)
    }
  }

  println(countRec(1, 4))
}
