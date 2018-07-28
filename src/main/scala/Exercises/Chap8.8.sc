import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

//What is this asking?

val rose = (angle: Angle) => Point.polar((angle * 7).cos * 200, angle)

def sample(start: Angle, samples: Int, location: Angle => Point): Image = {
  // Angle.one is one complete turn. I.e. 360 degrees
  val step = Angle.one / samples
  val dot = triangle(10, 10)
  def loop(count: Int): Image = {
    val angle = step * count
    count match {
      case 0 => Image.empty
      case n =>
        dot.at(location(angle).toVec) on loop(n - 1)
    }
  }
  loop(samples)
}

sample(0.degrees, 72, rose).draw