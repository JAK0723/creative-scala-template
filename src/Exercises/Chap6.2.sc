import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

def square(x: Int): Int = x * x

def halve(x: Double): Double = x / 2

println(square(12))
println(halve(5.24))

def example(a: Int, b: Int): Int = {
  println("In the method body!")
  a + b
}

example({println("a"); 1}, {println("b"); 2})