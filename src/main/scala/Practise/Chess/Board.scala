package Practise.Chess

import doodle.core.{Color, Image}

object Board {
  val blackSquare: Image = Image.rectangle(30, 30) fillColor Color.black
  val redSquare: Image = Image.rectangle(30, 30) fillColor Color.red

  val twoByTwo: Image =
    (redSquare   beside blackSquare) above
      (blackSquare beside redSquare)

  val fourByFour: Image =
    (twoByTwo beside twoByTwo) above
      (twoByTwo beside twoByTwo)

  val image: Image =
    (fourByFour beside fourByFour) above
      (fourByFour beside fourByFour)
}
