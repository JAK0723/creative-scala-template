import doodle.core.Point._
import doodle.core.PathElement._
import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

def ones(num: Int): List[Int] = {
  num match {
    case 0 => Nil
    case n => 1 :: ones(n - 1)
  }
}

println(ones(3))

def descending(num: Int): List[Int] = {
  num match {
    case 0 => Nil
    case n => n :: descending(n - 1)
  }
}

println(descending(3))

def ascending(num: Int): List[Int] = {
  def loop(i: Int, count: Int): List[Int] = {
    i match {
      case 0 => Nil
      case n => count :: loop(n - 1, count + 1)
    }
  }

  loop(num, 1)
}

println(ascending(3))

def fill[A](num: Int, a: A): List[A] = {
  num match {
    case 0 => Nil
    case n => a :: fill(n - 1, a)
  }
}

println(fill(3, "Hi"))
println(fill(3, Color.blue))

def double(list: List[Int]): List[Int] = {
  list match {
    case Nil => Nil
    case hd :: tl => (hd * 2) :: double(tl)
  }
}

println(double(List(1, 2, 3)))

def product(list: List[Int]): Int =
  list match {
    case Nil => 1
    case hd :: tl => hd * product(tl)
  }

println(product(List(1, 2, 3)))

def contains[A](list: List[A], item: A): Boolean = {
  list match {
    case Nil => false
    case hd :: tl =>
      if (hd == item) {
        true
      } else {
        contains(tl, item)
      }
  }
}

println(contains(List(1, 2, 3), 3))
println(contains(List("one", "two", "three"), "four"))

def first[A](list: List[A], item: A): A = {
  list match {
    case Nil => item
    case hd :: tl => hd
  }
}

println(first(Nil, 4))
println(first(List("One", "Two", "Three"), "Four"))

def reverse[A](list: List[A]): List[A] = {
  def loop(lis: List[A], rev: List[A]): List[A] = {
    lis match {
      case Nil => rev
      case hd :: tl => loop(tl, hd :: rev)
    }
  }

  loop(list, Nil)
}

println(reverse(List(1, 2, 3)))
println(reverse(List("a", "b", "c")))

def polygon(count: Int): Image = {
  val baseColor = Color.hsl(0.degrees, 0.7.normalized, 0.7.normalized)
  val size = 50

  def makeImage(num: Int): Image = {
    num match {
      case 0 => Image.empty
      case n =>
        val shape = makeShape(n, size)
        val color = makeColor(n, 30.degrees)
        makeImage(n - 1) on shape fillColor color lineWidth 5
    }
  }

  def makeColor(num: Int, spin: Angle): Color = {
    baseColor spin (spin * num)
  }

  def makeShape(num: Int, increment: Int): Image = {
    makePolygon(num + 2, num * increment, 0.degrees)
  }

  def makePolygon(sides: Int, size: Int, initialRotation: Angle): Image = {
    def loop(count: Int, rotation: Angle): List[PathElement] = {
      count match {
        case 0 => Nil
        case n => lineTo(polar(size, initialRotation + rotation * n)) :: loop(n - 1, rotation)
      }
    }
    closedPath(moveTo(polar(size, initialRotation)) :: loop(sides, 360.degrees / sides))
  }

  makeImage(count)
}

polygon(15).draw