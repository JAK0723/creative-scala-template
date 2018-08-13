import doodle.core.Point._
import doodle.core.PathElement._
import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

def ones(num: Int): List[Int] = {
  (0 until num).toList.map(x => 1)
}

println(ones(3))

def descending(num: Int): List[Int] = {
  (num until 0 by -1).toList.map(x => x)
}

println(descending(3))

def ascending(num: Int): List[Int] = {
  (0 until num).toList.map(x => x + 1)
}

println(ascending(3))

def double(list: List[Int]): List[Int] = {
  list.map(x => x * 2)
}

println(double(List(1, 2, 3)))

val baseColor = Color.hsl(0.degrees, 0.7.normalized, 0.7.normalized)
val size = 50

def polygon(sides: Int, size: Int, initialRotation: Angle): Image = {
  val step = (Angle.one / sides).toDegrees
  val path = Range.BigDecimal.inclusive(0.0, 360.0, step).map(_.toDouble).toList.map(deg =>
    lineTo(polar(size, initialRotation + deg.degrees)))

//  val path = (0.0 to 360.0 by step).toList.map(deg =>
//      lineTo(polar(size, initialRotation + deg.degrees)))

  closedPath(moveTo(polar(size, initialRotation)) :: path)
}

def makeShape(num: Int, increment: Int): Image = {
  polygon(num + 2, num * increment, 0.degrees)
}

def makeColor(num: Int, spin: Angle): Color = {
  baseColor spin (spin * num)
}

def makeImage(count: Int): Image = {
  count match {
    case 0 => Image.empty
    case n =>
      val shape = makeShape(n, size)
      val color = makeColor(n, 30.degrees)
      makeImage(n - 1) on shape fillColor color lineWidth 5
  }
}

makeImage(15).draw

def ascendingTo(num: Int): List[Int] = {
  (1 to num).toList.map(x => x)
}

println(ascending(3))

println(((x: Int) => x + 42)(10))