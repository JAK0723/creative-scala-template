import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

import scala.annotation.tailrec

val aBox = Image.rectangle(200, 200).fillColor(Color.royalBlue)

def boxes(count: Int): Image = {
  count match {
    case 0 => Image.empty
    case n => aBox beside boxes(n - 1)
  }
}

def boxesIf(count: Int): Image = {
  if (count == 0) {
    Image.empty
  } else {
    aBox beside boxesIf(count - 1)
  }
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

def besideXFail(base: Image, current: Image, count: Int): Image = {
  if (count == 0) {
    current
  } else {
    besideXFail(base, base beside current, count - 1)
  }
}

def besideX(image: Image, count: Int): Image = {
  if (count == 0) {
    Image.empty
  } else {
    image beside besideX(image, count - 1)
  }
}

def besideXFail2(image: Image, count: Int): Image = {
  val base = image

  def inner(i: Image, c: Int) : Image = {
    if(c == 0) {
      Image.empty
    } else {
      base beside inner(i, c - 1)
    }
  }
  inner(base, count)
}

def stackedBoxes(count: Int): Image = {
  count match {
    case 0 => Image.empty
    case n => aBox above stackedBoxes(n - 1)
  }
}

def printTriangle(count: Int): Unit = {
  count match {
    case 0 => println("Done")
    case n => println("*" * n); printTriangle(n - 1)
  }
}

def test(x: Int): Int = {
  x match {
    case 0 => 0
    case 1 => 1
  }
}

//test(2)

//besideXFail(aBox, Image.empty, 3).draw
besideXFail2(circle(200) fillColor Color.red lineWidth 10, 4).draw

//stackedBoxes(5).draw

//printTriangle(4)