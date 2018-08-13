import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._
import doodle.random.Random

val randomAngle: Random[Angle] = {
  Random.double.map(x => x.turns)
}

def randomColor(s: Normalized, l: Normalized): Random[Color] = {
  randomAngle map (hue => Color.hsl(hue, s, l))
}

def randomCircle(r: Double, color: Random[Color]): Random[Image] = {
  color map (fill => Image.circle(r) fillColor fill)
}

randomCircle(200, randomColor(0.5.normalized, 0.5.normalized)).run.draw