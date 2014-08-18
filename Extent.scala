package shape

import area._

class Extent(
              var topX: Double,
              var topY: Double,
              var bottomX: Double,
              var bottomY: Double) extends AreaItem {
  def area(): Double = (bottomX - topX) * (topY - bottomY)
}
