import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

val aBox = Image.rectangle(200, 200).fillColor(Color.royalBlue)

def boxes(count: Int): Image =
  count match {
    case 0 => Image.empty
    case n => aBox beside boxes(n - 1)
  }

def boxesIf(count: Int): Image =
  if (count == 0) {
    Image.empty
  } else {
    aBox beside boxesIf(count - 1)
  }

def boxesIter(count: Int): Image = {
  var num = count
  var result = Image.empty

  while (num > 0) {
    result = result beside aBox
    num -= 1
  }
  result
}

def besideX(base: Image, current: Image, count: Int): Image =
  if (count == 0) {
    current
  } else {
    besideX(base, base beside current, count - 1)
  }

def stackedBoxes(count: Int): Image =
  count match {
    case 0 => Image.empty
    case n => aBox above stackedBoxes(n - 1)
  }

def printTriangle(count: Int): Unit =
  count match {
    case 0 => println("Done")
    case n => println("*" * n); printTriangle(n - 1)
  }

def test(x: Int): Int =
  x match {
    case 0 => 0
    case 1 => 1
  }

test(2)

//besideX(aBox, Image.empty, 3).draw
stackedBoxes(5).draw

//printTriangle(4)