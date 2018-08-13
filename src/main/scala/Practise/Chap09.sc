import doodle.core.Point._
import doodle.core.PathElement._
import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._


//val triangle =
//  List(
//    lineTo(cartesian(50, 100)),
//    lineTo(cartesian(100, 0)),
//    lineTo(cartesian(0, 0))
//  )
//val curve =
//  List(curveTo(cartesian(50, 100), cartesian(100, 100), cartesian(150, 0)))
//def style(image: Image): Image =
//  image.
//    lineWidth(6.0).
//    lineColor(Color.royalBlue).
//    fillColor(Color.skyBlue)
//val openPaths =
//  style(openPath(triangle) beside openPath(curve))
//val closedPaths =
//  style(closedPath(triangle) beside closedPath(curve))
//val paths = openPaths above closedPaths

//paths.draw

val trianglePolar = closedPath(List(
  moveTo(polar(300, 0.degrees)),
  lineTo(polar(300, 120.degrees)),
  lineTo(polar(300, 240.degrees))))

val squarePolar = closedPath(List(
  moveTo(300, 45.degrees),
  lineTo(polar(300, 135.degrees)),
  lineTo(polar(300, 225.degrees)),
  lineTo(polar(300, 315.degrees))))

val pentagonPolar = closedPath(List(
  moveTo(300, 72.degrees),
  lineTo(polar(300, 144.degrees)),
  lineTo(polar(300, 216.degrees)),
  lineTo(polar(300, 288.degrees)),
  lineTo(polar(300, 360.degrees))))

val triangleCartesian = closedPath(List(
  lineTo(cartesian(0, 300)),
  lineTo(cartesian(300, 150))))

val squareCartesian = closedPath(List(
  lineTo(cartesian(0, 300)),
  lineTo(cartesian(300, 300)),
  lineTo(cartesian(300, 0))))

val pentagonCartesian = closedPath(List(
  moveTo(cartesian(0, 25)),
  lineTo(cartesian(0, 275)),
  lineTo(cartesian(250, 350)),
  lineTo(cartesian(375, 150)),
  lineTo(cartesian(250, -50))))

def style(img: Image): Image = {
  img fillColor Color.turquoise lineColor Color.paleTurquoise lineWidth 30
}

val spacer = rectangle(100, 100).noFill.noLine

//(style(trianglePolar) beside spacer beside style(squarePolar) beside spacer beside style(pentagonPolar)).draw
//(style(triangleCartesian) beside spacer beside style(squareCartesian) beside spacer beside style(pentagonCartesian)).draw

def curveLine(radius: Int, start: Angle, increment: Angle): PathElement = {
  curveTo(
    polar(radius * 0.95, start + increment * 0.05),
    polar(radius * 1.05, start + increment * 0.1),
    polar(radius, start + increment)
  )
}

val triangleCurve = closedPath(List(
  moveTo(polar(300, 0.degrees)),
  curveLine(300, 0.degrees, 120.degrees),
  curveLine(300, 120.degrees, 120.degrees),
  curveLine(300, 240.degrees, 120.degrees)))

//val squareCurve = closedPath(List(
//  moveTo(300, 45.degrees),
//  curveLine(300, 135.degrees, 90.degrees),
//  curveLine(300, 225.degrees, 90.degrees),
//  curveLine(300, 315.degrees, 90.degrees)))

val squareCurve = closedPath(List(
  moveTo(300, 45.degrees),
  curveLine(300, 135.degrees, 90.degrees),
  curveLine(300, 225.degrees, 90.degrees),
  curveLine(300, 315.degrees, 90.degrees)))

val pentagonCurve = closedPath(List(
  moveTo(300, 72.degrees),
  curveLine(300, 144.degrees, 72.degrees),
  curveLine(300, 216.degrees, 72.degrees),
  curveLine(300, 288.degrees, 72.degrees),
  curveLine(300, 360.degrees, 72.degrees)))

//(style(triangleCurve) beside
//  spacer beside style(squareCurve) beside
//  spacer beside style(pentagonCurve)).draw

def increment(list: List[Int]): List[Int] =
  list match {
    case Nil => Nil
    case hd :: tl => (hd + 1) :: increment(tl)
  }

def sum(list: List[Int]): Int =
  list match {
    case Nil => 0
    case hd :: tl => hd + sum(tl)
  }

println(increment(List(1, 2, 3)))
println(sum(List(1, 2, 3)))

val list = List(1, 2, 3)
val head :: tail = list

println(head == list.head)
println(tail == list.tail)

println(list.size)

println(tail.tail)

def length[A](list: List[A]): Int =
  list match {
    case Nil => 0
    case _ :: tl => 1 + length(tl)
  }

println(length(list))

val list2 = List(4, 5, 6)

list ++ list2

def map(op: Int => Int, list: List[Int]): List[Int] = {
  list match {
    case Nil => Nil
    case hd :: tl => op(hd) :: map(op, tl)
  }
}

println(map((x: Int) => x * 2, List(1, 2, 3, 4)))

def mapG[A, B](op: A => B, list: List[A]): List[B] = {
  list match {
    case Nil => Nil
    case hd :: tl => op(hd) :: mapG(op, tl)
  }
}

println(mapG((x: Int) => "Hello " + x, List(1, 2, 3, 4)))