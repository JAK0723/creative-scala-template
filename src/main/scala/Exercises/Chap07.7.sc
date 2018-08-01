import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

def cross(count: Int): Image = {
  val unit = circle(50) lineWidth 5

  def loop(i: Int): Image = {
    i match {
      case 0 => unit
      case n => unit beside (loop(n - 1) above unit below unit) beside unit
    }
  }
  loop(count)
}

//cross(3).draw

def chessboard(count: Int): Image = {
  val blackSquare = rectangle(50, 50) fillColor Color.black
  val redSquare = rectangle(50, 50) fillColor Color.red
  val base = (redSquare beside blackSquare) above (blackSquare beside redSquare)

  def loop(i: Int): Image = {
    i match {
      case 0 => base
      case n =>
        val unit = loop(n - 1)
        (unit beside unit) above (unit beside unit)
    }
  }
  loop(count)
}

//chessboard(3).draw

def boxes(count: Int): Image = {
  val aBox = Image.rectangle(200, 200).fillColor(Color.royalBlue)

  def loop(i: Int): Image = {
    i match {
      case 0 => Image.empty
      case n => aBox beside boxes(n - 1)
    }
  }
  loop(count)
}

boxes(5).draw