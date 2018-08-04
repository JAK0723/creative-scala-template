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

val stepSize = 10

def rule(i: Instruction): List[Instruction] =
  i match {
    case Forward(_) => List(forward(stepSize), forward(stepSize))
    case NoOp =>
      List(branch(turn(45.degrees), forward(stepSize), noop),
        branch(turn(-45.degrees), forward(stepSize), noop))
    case other => List(other)
  }

//def turtleDraw(count: Int, i: Instruction): List[Instruction] = {
//  def loop(num: Int, list: List[Instruction]): List[Instruction] = {
//    list match {
//      case Nil => rule(i)
//      case x => x ++ rule(i)
//    }
//  }
//  loop(count, List(i))
//}

//Turtle.draw(turtleDraw(5, turn(45.degrees))).draw
//Turtle.draw(rule(NoOp)).draw