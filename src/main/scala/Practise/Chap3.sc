import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._
import doodle.core

//val c1 = circle(500)
//c1.draw

//(circle(400) beside rectangle(500, 800)).draw

//(circle(900) under (circle(300) beside circle(300) beside circle(300))
//  lineWidth 10 fillColor Color.gray).draw

//(circle 900 lineWidth 20).draw
// Why doesn't this work?

//(circle(900) fillColor Color.gray lineWidth 20 under circle(300) fillColor Color.black).draw
//
//circle(900).fillColor(Color.gray).lineWidth(20).under(circle(300).fillColor(Color.black)).draw

//((circle(900) lineWidth 15 fillColor Color.darkBlue) under
//  (circle(600) lineWidth 15 fillColor Color.gray) under
//  (circle(400) lineWidth 15 fillColor Color.cornflowerBlue) under
//  (circle(200) fillColor Color.rgb(0.uByte, 0.uByte, 0.uByte))).draw
//
//((circle(100) fillColor Color.red) beside
//  (circle(100) fillColor Color.red.spin(15.degrees)) beside
//  (circle(100) fillColor Color.red.spin(30.degrees))).lineWidth(5.0).draw

//(circle(100) fillColor Color.red beside circle(100) fillColor Color.red.spin(15.degrees) beside circle(100) fillColor Color.red.spin(30.degrees)).draw

//var circle1 = circle(100) //fillColor Color.red
//var red = Color.red
//var i = 0
//
//
//circle(900) fillColor Color.red
//
//(circle1 fillColor red beside circle1 fillColor red.spin(15.degrees) beside circle1 fillColor red.spin(30.degrees)).draw

//(c1 beside circle(100) fillColor Color.red.spin(15.degrees) beside circle(100) fillColor Color.red.spin(30.degrees)).draw

var col = Color.darkSlateBlue
var size = 400
var width = 30

((triangle(size, size) lineWidth width lineColor col fillColor col.lighten(0.3.normalized)) above
  ((triangle(size, size) lineWidth width lineColor col.spin(-30.degrees) fillColor  col.spin(-30.degrees).lighten(0.3.normalized)) beside
  (triangle(size, size) lineWidth width lineColor col.spin(30.degrees) fillColor  col.spin(30.degrees).lighten(0.3.normalized)))
  ).draw