import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

((circle(300) fillColor Color.red lineWidth 10) under
  (circle(200) fillColor Color.lightGrey lineWidth 10) under
  (circle(100) fillColor Color.red lineWidth 10) above
  (rectangle(50, 200) fillColor Color.lightGrey lineWidth 20) above
  (rectangle(200, 70) fillColor Color.brown lineWidth 10) above
  (rectangle(800, 250) fillColor Color.green lineWidth 0)).draw