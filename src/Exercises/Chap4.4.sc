import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

val target = circle(300) fillColor Color.red lineWidth 10 under
  circle(200) fillColor Color.lightGrey lineWidth 10 under
  circle(100) fillColor Color.red lineWidth 10

val stand = rectangle(50, 200) fillColor Color.lightGrey lineWidth 20 above
  rectangle(200, 70) fillColor Color.brown lineWidth 10

val ground = rectangle(800, 250) fillColor Color.green lineWidth 0

val archeryTarget = target above stand above ground

archeryTarget.draw



val roof = triangle(215, 130) fillColor Color.brown lineWidth 0

val doorway = rectangle(90, 120) fillColor Color.red lineWidth 0 beside
  rectangle(35, 120) fillColor Color.black lineWidth 0 beside
  rectangle(90, 120) fillColor Color.red lineWidth 0 below
  rectangle(215, 40) fillColor Color.red lineWidth 0

val tree = circle(100) fillColor Color.green lineWidth 0 above
  rectangle(40, 90) fillColor Color.brown lineWidth 0

val house = roof above doorway beside tree

val roadSegment = rectangle(170, 10) fillColor Color.yellow lineWidth 0 beside
  rectangle(30, 10) fillColor Color.black lineWidth 0 above
  rectangle(200, 30) fillColor Color.black lineWidth 0

val road = roadSegment beside roadSegment beside roadSegment

val lot = house above road

val street = lot beside lot beside lot

street.draw