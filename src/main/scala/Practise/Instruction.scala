package Practise

import doodle.core.{Angle, Vec}

abstract class Instruction {
  case class Forward(distance: Double) extends Instruction
  case class Turn(angle: Angle) extends Instruction
  case class TurtleState(at: Vec, heading: Angle)
}
