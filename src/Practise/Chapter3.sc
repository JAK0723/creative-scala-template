import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

//val c1 = circle(500)
//c1.draw

//(circle(400) beside rectangle(500, 800)).draw
//(circle(900) under (circle(300) beside circle(300) beside circle(300))
//  lineWidth 10 fillColor Color.gray).draw

//((circle(900) lineWidth 15 fillColor Color.darkBlue) under
//  (circle(600) lineWidth 15 fillColor Color.gray) under
//  (circle(400) lineWidth 15 fillColor Color.cornflowerBlue) under
//  (circle(200) fillColor Color.rgb(0.uByte, 0.uByte, 0.uByte))).draw

//((circle(100) fillColor Color.red) beside
//  (circle(100) fillColor Color.red.spin(15.degrees)) beside
//  (circle(100) fillColor Color.red.spin(30.degrees))).lineWidth(5.0).draw

var c1 = circle(100) fillColor Color.red

(circle(100) fillColor Color.red beside circle(100) fillColor Color.red.spin(15.degrees) beside circle(100) fillColor Color.red.spin(30.degrees)).draw