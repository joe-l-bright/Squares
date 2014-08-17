package shape

class Extent(
        var topX: Double,
        var topY: Double,
        var bottomX: Double,
        var bottomY: Double) extends area.AreaItem
{
  def area(): Double =
     (bottomX - topX) * (bottomY - topY)
  def print() = println(
    topX + " " + topY + " " + bottomX + " " + bottomY)
}
