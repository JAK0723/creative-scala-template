import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._
import doodle.core.PathElement.{lineTo, moveTo}
import doodle.core.Point.polar
import doodle.turtle._
import doodle.turtle.Instruction._

def makePolygon(sides: Int, sideLength: Double): Image = {
  val rotation = Angle.one / sides

  def loop(count: Int): List[Instruction] = {
    count match {
      case 0 => Nil
      case n => turn(rotation) :: forward(sideLength) :: loop(n - 1)
    }
  }
  Turtle.draw(loop(sides))
}

//makePolygon(5, 200).draw

def squareSpiral(steps: Int, distance: Double, angle: Angle, increment: Double): Image = {
  def loop(num: Int, distance: Double): List[Instruction] = {
    num match {
      case 0 => Nil
      case n => forward(distance) :: turn(angle) :: loop(n - 1, distance + increment)
    }
  }
  Turtle.draw(loop(steps, distance))
}

squareSpiral(400, 20, 89.9.degrees, 3).draw