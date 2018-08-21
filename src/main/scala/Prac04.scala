import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

object Prac04 {
	def main(args: Array[String]): Unit = {
		Turtle.draw(List(Forward(80), PenToggle(), Turn(90.degrees), Forward(120), PenToggle(), Turn(90.degrees), Forward(120))).draw
  }
}