import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._
import doodle.core.PathElement.{lineTo, moveTo}
import doodle.core.Point.polar
import doodle.turtle._
import doodle.turtle.Instruction._

def double[A](list: List[A]): List[A] = {
  list.flatMap(x => List(x, x))
}

println(double(List(1, 2, 3)))

def nothing[A](list: List[A]): List[A] = {
  list.flatMap(_ => List[A]())
}

println(nothing(List(1, 2, 3)))

val stepSize = 5

def rule(i: Instruction): List[Instruction] =
  i match {
    case Forward(_) => List(forward(stepSize), forward(stepSize))
    case NoOp =>
      List(branch(turn(45.degrees), forward(stepSize), noop),
        branch(turn(-45.degrees), forward(stepSize), noop))
    case other => List(other)
  }

def rewrite(instructions: List[Instruction], rule: Instruction => List[Instruction]): List[Instruction] = {
  instructions.flatMap(
    i => i match {
      case Branch(x) => List(branch(rewrite(x, rule): _*))
      case other => rule(other)
    }
  )
}

def iterate(steps: Int, seed: List[Instruction], rule: Instruction => List[Instruction]): List[Instruction] = {
  steps match {
    case 0 => seed
    case n => iterate(n - 1, rewrite(seed, rule), rule)
  }
}



//Turtle.draw(iterate(5, ))

val seed = List(forward(stepSize),
  branch(turn(45.degrees), forward(stepSize), noop),
  branch(turn(-45.degrees), forward(stepSize), noop))

Turtle.draw(iterate(5, seed, rule)).draw