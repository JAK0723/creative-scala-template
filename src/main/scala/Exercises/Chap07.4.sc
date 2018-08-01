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

cross(3).draw

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
    result = result above row(x)
    x += 1
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

//chessboard(4).draw
//chessboardLoop(4).draw

def sierpinski(count: Int): Image = {
  val base = triangle(10, 10) lineColor Color.magenta lineWidth 3

  count match {
    case 0 => base
    case n =>
      val unit = sierpinski(n - 1)
      (unit beside unit) below unit
  }
}

//sierpinski(100).draw

val aBox = rectangle(200, 200)

def gradientBoxes(count: Int): Image = {
  count match {
    case 0 => Image.empty
    case n => gradientBoxes(n - 1) beside aBox fillColor Color.royalBlue.spin((15 * (n - 1)).degrees)
  }
}

def gradientBoxes(count: Int, col: Color): Image = {
  count match {
    case 0 => Image.empty
    case n => aBox fillColor col beside gradientBoxes(n - 1, col.spin(15.degrees))
  }
}

//gradientBoxes(5).draw
//gradientBoxes(5, Color.royalBlue).draw

def concentricCircles(count: Int): Image = {
  count match {
    case 0 => Image.empty
    case n =>
      val aCircle = circle(30 + n * 10) lineColor Color.royalBlue lineWidth 5
      aCircle under concentricCircles(n - 1)
  }
}

def concentricCircles(count: Int, size: Int): Image = {
  count match {
    case 0 => Image.empty
    case n =>
      val aCircle = circle(size) lineColor Color.royalBlue lineWidth 5
      aCircle under concentricCircles(n - 1, size + 10)
  }
}

//concentricCircles(40).draw
//concentricCircles(40, 40).draw

def circlesFade(count: Int): Image = {
  count match {
    case 0 => Image.empty
    case n =>
      val aCircle = circle(30 + n * 10) lineColor Color.red.fadeOutBy((0.05 * n).normalized) lineWidth 5
      aCircle under circlesFade(n - 1)
  }
}

def circlesHue(count: Int): Image = {
  count match {
    case 0 => Image.empty
    case n =>
      val aCircle = circle(30 + n * 10) lineColor Color.royalBlue.spin((15 * n).degrees) lineWidth 5
      aCircle under circlesHue(n - 1)
  }
}

(circlesFade(20) beside circlesHue(20)).draw