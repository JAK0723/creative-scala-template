import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._
import doodle.turtle._
import doodle.turtle.Instruction._

val instructions = List(
  forward(400), turn(90.degrees),
  forward(400), turn(90.degrees),
  forward(400), turn(90.degrees),
  forward(400))

val path = Turtle.draw(instructions) lineWidth 10

//path.draw