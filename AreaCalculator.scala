package area

import shape.Extent

object AreaCalculator
{
  def findTotalArea(xs:List[AreaItem]): Double = {
    xs.foldLeft(0.0)((acc, elem) =>
      acc + elem.area
    )
  }

  def findAverageArea(xs:List[AreaItem]): Double = {
    findTotalArea(xs) / xs.length
  }

  def findTotalExtentArea(xs:List[ExtentItem]): Double = {
    val topX = xs.reduceLeft((l, r) =>
      if (l.extent().topX < r.extent().topX) l else r
    ).extent.topX
    val topY = xs.reduceLeft((l, r) =>
      if (l.extent().topY > r.extent().topY) l else r
    ).extent.topY
    val bottomX = xs.reduceLeft((l, r) =>
      if (l.extent().bottomX < r.extent().bottomX) l else r
    ).extent.bottomX
    val bottomY = xs.reduceLeft((l, r) =>
      if (l.extent().bottomY > r.extent().bottomY) l else r
    ).extent.bottomY
    println(topX + " " + topY + " " + bottomX + " " + bottomY)
    new Extent(topX, topY, bottomX, bottomY).area
  }
}

trait AreaItem {
  def area(): Double
}

trait ExtentItem {
  def extent(): Extent
}
