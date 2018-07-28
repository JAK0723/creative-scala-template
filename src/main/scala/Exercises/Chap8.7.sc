import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

def concentricShapes(count: Int, singleShape: Int => Image): Image = {
  count match {
    case 0 => Image.empty
    case n => singleShape(n) on concentricShapes(n - 1, singleShape)
  }
}

val blackCircles = concentricShapes(10, (n: Int) => circle(200 + 20 * n))

//blackCircles.draw

//val rainbowCircle = concentricShapes(10, (n: Int) =>
//  circle(100 + 25 * n) lineWidth 20 lineColor
//    Color.blue.desaturate(0.5.normalized).spin((n * 30).degrees))
//
//val rainbowSquare = concentricShapes(10, (n: Int) =>
//  square(200 + 50 * n) lineWidth 20 lineColor
//    Color.blue.desaturate(0.5.normalized).spin((n * 30).degrees))
//
//val fadingTriangle = concentricShapes(10, (n: Int) =>
//  triangle(750 - 50 * n, 750 - 50 * n) lineWidth 15 lineColor
//    Color.blue.fadeOutBy((0.1 * n).normalized))

//(rainbowCircle beside fadingTriangle beside rainbowSquare).draw

//def rainbowCircle(n: Int): Image = {
//  val color = Color.blue desaturate 0.5.normalized spin (n * 30).degrees
//  val shape = Image.circle(50 + n*12)
//  shape lineWidth 10 lineColor color
//}
//
//def fadingTriangle(n: Int): Image = {
//  val color = Color.blue fadeOut (1 - n / 20.0).normalized
//  val shape = Image.triangle(100 + n*24, 100 + n*24)
//  shape lineWidth 10 lineColor color
//}
//
//def rainbowSquare(n: Int): Image = {
//  val color = Color.blue desaturate 0.5.normalized spin (n * 30).degrees
//  val shape = Image.rectangle(100 + n*24, 100 + n*24)
//  shape lineWidth 10 lineColor color
//}
//
//val rainbowCircleFunc = rainbowCircle _
//val fadingTriangleFunc = fadingTriangle _
//val rainbowSquareFunc = rainbowSquare _

//val answer = concentricShapes(10, rainbowCircle) beside
//  concentricShapes(10, fadingTriangle) beside
//  concentricShapes(10, rainbowSquare)

//val answer = concentricShapes(10, rainbowCircleFunc) beside
//  concentricShapes(10, fadingTriangleFunc) beside
//  concentricShapes(10, rainbowSquareFunc)

//answer.draw

//val rainbowCircle = concentricShapes(10, (n: Int) => {
//  val color = Color.blue desaturate 0.5.normalized spin (n * 30).degrees
//  val shape = circle(150 + n * 36)
//  shape lineWidth 30 lineColor color})
//
//val fadingTriangle = concentricShapes(10, (n: Int) => {
//  val color = Color.blue fadeOut (1 - n / 20.0).normalized
//  val shape = Image.triangle(300 + n * 72, 300 + n * 72)
//  shape lineWidth 30 lineColor color})
//
//val rainbowSquare = concentricShapes(10, (n: Int) => {
//  val color = Color.blue desaturate 0.5.normalized spin (n * 30).degrees
//  val shape = Image.rectangle(300 + n * 72, 300 + n * 72)
//  shape lineWidth 30 lineColor color})

def spinning(n: Int): Color = {
  Color.blue desaturate 0.5.normalized spin (n * 30).degrees
}

def fading(n: Int): Color = {
  Color.blue fadeOut (1 - n / 20.0).normalized
}

def size(n: Int): Int = {
  300 + 72 * n
}

def sizeHalf(n: Int): Int = {
  150 + 36 * n
}

def circ(n: Int): Image = {
  circle(sizeHalf(n))
}

def tri(n: Int): Image = {
  triangle(size(n), size(n))
}

def rec(n: Int): Image = {
  rectangle(size(n), size(n))
}

// Which format is preferred?
def colored(shape: Int => Image, color: Int => Color): Int => Image = {
  n: Int => shape(n) lineWidth 30 lineColor color(n)
}

//def colored(shape: Int => Image, color: Int => Color): Int => Image = (n: Int) => {
//  shape(n) lineWidth 30 lineColor color(n)
//}

val count = 10
val rainbowCircle = concentricShapes(count, colored(circ, spinning))
val fadingTriangle = concentricShapes(count, colored(tri, fading))
val rainbowSquare = concentricShapes(count, colored(rec, spinning))

(rainbowCircle beside fadingTriangle beside rainbowSquare).draw