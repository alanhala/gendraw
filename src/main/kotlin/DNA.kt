import shapes.Ellipse
import shapes.Rectangle
import shapes.Shape
import shapes.ShapeType
import java.awt.Color
import java.awt.Graphics
import kotlin.random.Random

class DNA {
    var genes: List<Shape>

    constructor(genes: List<Shape>) {
        this.genes = genes
    }

    constructor() {
        genes = (0 until Configuration.dnaSize).map {
            when (ShapeType.values().random()) {
                ShapeType.ELLIPSE -> newEllipse()
                ShapeType.RECTANGLE -> newRectangle()
            }
        }
    }

    fun draw(graphics: Graphics) {
        graphics.color = Color.BLACK
        graphics.fillRect(0, 0, Configuration.width, Configuration.height)
        genes.forEach { gene -> gene.draw(graphics) }
    }

    private fun newRectangle(): Shape {
        val x = Random.nextInt(Configuration.width)
        val y = Random.nextInt(Configuration.height)
        val w = Utils.bound(Random.nextInt(Configuration.width / 4), 2, Configuration.width - x)
        val h = Utils.bound(Random.nextInt(Configuration.height / 4), 2, Configuration.height - y)
        val color = Color(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))
        return Rectangle(x, y, w, h, color)
    }

    private fun newEllipse(): Shape {
        val x = Random.nextInt(Configuration.width)
        val y = Random.nextInt(Configuration.height)
        val w = Utils.bound(Random.nextInt(Configuration.width / 4), 2, Configuration.width - x)
        val h = Utils.bound(Random.nextInt(Configuration.height / 4), 2, Configuration.height - y)
        val color = Color(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))
        return Ellipse(x, y, w, h, color)
    }
}