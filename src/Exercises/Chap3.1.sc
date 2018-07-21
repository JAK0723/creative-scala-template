import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

circle(1).draw
circle(10).draw
circle(100).draw

// circle, rectangle and triangle are all of type Image

// the type of drawing an image is Unit, which means nothing is returned