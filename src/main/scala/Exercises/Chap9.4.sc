import doodle.core.Point._
import doodle.core.PathElement._
import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

def star(p: Int, n: Int, radius: Double): Image = {
  val step = (Angle.one / p).toDegrees
  val path = Range.BigDecimal.inclusive(0.0, 360.0, step).map(_.toDouble).toList.map(deg =>
    lineTo(polar(radius, deg.degrees * n)))
  closedPath(moveTo(polar(radius, 0.degrees)) :: path)
}

def allBeside(images: List[Image]): Image = {
  images match {
    case Nil => Image.empty
    case hd :: tl => hd beside allBeside(tl)
  }
}

val sides = 11

allBeside((1 to (sides / 2)).toList map (skip => star(sides, skip, 100))).draw