import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

def cross(count: Int): Image = {
  val unit = circle(50) lineWidth 5
  count match {
    case 0 => unit
    case n => unit beside (cross(n - 1) above unit below unit) beside unit
  }
}

//cross(3).draw

def chessboard(count: Int): Image = {
  val blackSquare = rectangle(50, 50) fillColor Color.black
  val redSquare = rectangle(50, 50) fillColor Color.red
  val base = (redSquare beside blackSquare) above (blackSquare beside redSquare)

  count match {
    case 0 => base
    case n =>
      val unit = chessboard(n - 1)
      (unit beside unit) above (unit beside unit)
  }
}

def chessboardLoop(count: Int): Image = {
  val blackSquare = rectangle(50, 50) fillColor Color.black
  val redSquare = rectangle(50, 50) fillColor Color.red
  val max = Math.pow(2, 1 + count)
  var x = 0
  var y = 0
  var result = Image.empty

  while (x < max) {
//    while (y < max) {
//      if ((x + y) % 2 == 0) {
//        result = result beside redSquare
//      } else {
//        result = result beside blackSquare
//      }
//      y += 1
//    }
    result = result above row(x)
    x += 1
//    if ((x + y) % 2 == 0) {
//      result = result above redSquare
//    } else {
//      result = result above blackSquare
//    }
//    y = 1
//    x += 1
  }
  def row(i: Int): Image = {
    var res = Image.empty
    var temp = 0

    while (temp < max) {
      if ((temp + x) % 2 == 0) {
        res = res beside redSquare
      } else {
        res = res beside blackSquare
      }
      temp += 1
    }
    res
  }
  result
}

chessboard(4).draw
//chessboardLoop(4).draw