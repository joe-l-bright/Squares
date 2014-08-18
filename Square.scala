package shape

import area._

class Square(
        var x: Double,
        var y: Double,
        var width: Double,
        var height: Double) extends area.AreaItem with area.ExtentItem
{
    def area(): Double = width * height
    def extent(): Extent = new Extent(x, y, x+width, y-height)
}
