import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

//Example

//val one = 1
//val anImage = Image.circle(100).fillColor(Color.red)
//
//anImage
//
//anImage.draw

//object ObjectExample {
//  val hi = "Hi!"
//}
//
//ObjectExample.hi

//val box = (rectangle(400, 400)
//  lineWidth 50
//  lineColor Color.royalBlue.spin(30.degrees)
//  fillColor Color.royalBlue
//  )
//
//(box beside box beside box beside box beside box).draw


/* // Non-functional?
def besideX(image: Image, x: Int): Image = {
  var i = 0
  var result = Image.empty

  while (i < x) {
    result = result beside image
    i += 1
  }
  result
}

val lowRoad = rectangle(2700, 50) fillColor Color.black lineWidth 0

val highRoadSegment = rectangle(250, 20) fillColor Color.yellow lineWidth 0 beside
  rectangle(50, 20) fillColor Color.black lineWidth 0

val highRoad = besideX(highRoadSegment, 9)

val road = highRoad above lowRoad

road.draw
*/