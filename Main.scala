package shape

import scala.io.Source
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {
  def main(args: Array[String]) {
    var squares = ListBuffer[Square]()
    args foreach(println)
    for(line <- Source fromFile("squares.txt") getLines()){
      var sqrDtl = ListBuffer[Double]()
      line split(",") map { x =>
        println(x)
        val tmp = x.toDouble
        println(tmp)
        sqrDtl.append(tmp)
      }
      squares += new Square(
        sqrDtl(0),
        sqrDtl(1),
        sqrDtl(2),
        sqrDtl(3)
      )
    }
    squares.foreach(x => x.extent().print())
    println("Number of Squares: " + squares.length)
    println("Total Area: " + area.AreaCalculator.findTotalArea(squares.toList))
    println("Average Area: " + area.AreaCalculator.findAverageArea(squares.toList))
    println("Total Extent: " + area.AreaCalculator.findTotalExtentArea(squares.toList))
    println("enter a value :)")
  }
}
