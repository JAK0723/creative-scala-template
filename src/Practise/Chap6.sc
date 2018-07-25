import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

def boxes(color: Color): Image = {
  val box =
    Image.rectangle(40, 40).
      lineWidth(5.0).
      lineColor(color.spin(30.degrees)).
      fillColor(color)
  besideX(box, 5)
}

def besideX(image: Image, x: Int): Image = {
  var i = 0
  var result = Image.empty

  while (i < x) {
    result = result beside image
    i += 1
  }
  result
}

// Create boxes with different colors
boxes(Color.paleGoldenrod)
boxes(Color.lightSteelBlue)
boxes(Color.mistyRose)