import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

println("test")
println("test")
println("test")

val a: Unit = println("test")
a
a
a


Image.rectangle(
  {println("a"); 20},
  {println("b"); 40}
)

Color.hsl(
  {println("a"); 20.degrees},
  {println("b"); 1.normalized},
  {println("c"); 1.normalized}
)

{}

{println("a"); 1} + {println("b"); 2} + {println("c"); 3}