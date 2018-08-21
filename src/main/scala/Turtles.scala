import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._
import PathElement._

abstract class Instruction
case class Forward(distance : Double) extends Instruction
case class Turn(angle : Angle) extends Instruction
case class PenToggle() extends Instruction

case class TurtleState(at: Vec, heading: Angle, pen: Boolean)

object Turtle {

  def draw(instructions: List[Instruction]): Image = {

    def iterate(state: TurtleState, instructions: List[Instruction]): List[PathElement] = instructions match {
        case Nil =>
          Nil
        case i :: is =>
          val (newState, elements) = process(state, i)
          elements ++ iterate(newState, is)
    }

    def process(state: TurtleState, instruction: Instruction): (TurtleState, List[PathElement]) = {
        instruction match {
            case Forward(d) =>
                val nowAt = state.at + Vec.polar(d, state.heading)
                val element = if (state.pen) lineTo(nowAt.toPoint) else moveTo(nowAt.toPoint)
				(state.copy(at = nowAt), List(element))
			case PenToggle() =>
				(state.copy(pen = !state.pen), List())
            case Turn(a) =>
                val nowHeading = state.heading + a
                (state.copy(heading = nowHeading), List())
        }
    }

    openPath(iterate(TurtleState(Vec.zero, Angle.zero, true), instructions))
  }
}
