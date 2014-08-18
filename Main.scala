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
        val tmp = x.toDouble
        sqrDtl.append(tmp)
      }
      squares += new Square(
        sqrDtl(0),
        sqrDtl(1),
        sqrDtl(2),
        sqrDtl(3)
      )
    }

    println("Number of Squares: " + squares.length)
    println("Total Area: " + area.AreaCalculator.findTotalArea(squares.toList))
    println("Average Area: " + area.AreaCalculator.findAverageArea(squares.toList))
    println("Total Extent Area: " + area.AreaCalculator.findTotalExtentArea(squares.toList))

    println()
    for(x <- -9 to 9){
      for(y <- -9 to 9){
        if (squares.exists(square =>
          x > square.extent.topX && x < square.extent.bottomX
                && y > square.extent.bottomY && y < square.extent.topY))
          print("X")
        else
          print(Math.abs(y))
      }
      println()
    }
    println()

    println()
    for(x <- -9 to 9){
      for(y <- -9 to 9){
        val extent = area.AreaCalculator.findTotalExtent(squares.toList)
        if (x > extent.topX && x < extent.bottomX
                && y > extent.bottomY && y < extent.topY)
          print("X")
        else
          print(Math.abs(y))
      }
      println()
    }
    println()
  }
}
