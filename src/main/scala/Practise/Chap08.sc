import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

val dot = Image.circle(50).lineWidth(3).lineColor(Color.crimson)
val squareDots =
  dot.at(0, 0) on dot.at(0, 500) on dot.at(500, 500) on dot.at(500, 0)

//squareDots.draw

def parametricCircle(angle: Angle): Point =
  Point.polar(200, angle)

//def rose(angle: Angle) =
//  Point.polar((angle * 7).cos * 200, angle)

//def rose(angle: Angle) =
//  Point.cartesian((angle * 7).cos * 200 * angle.cos, (angle * 7).cos * 200 * angle.sin)

val rose = (angle: Angle) => Point.polar((angle * 7).cos * 200, angle)

def sample(start: Angle, samples: Int): Image = {
  // Angle.one is one complete turn. I.e. 360 degrees
  val step = Angle.one / samples
  val dot = triangle(10, 10)
  def loop(count: Int): Image = {
    val angle = step * count
    count match {
      case 0 => Image.empty
      case n =>
        dot.at(rose(angle).toVec) on loop(n - 1)
    }
  }
  loop(samples)
}

sample(0.degrees, 72).draw

val addTen = (a: Int) => a + 10
val double = (a: Int) => a * 2
val combined = addTen andThen double

//println(combined(5))

