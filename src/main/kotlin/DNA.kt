import shapes.Shape
import shapes.Triangle
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
            val p1 = Pair(Random.nextInt(Configuration.width), Random.nextInt(Configuration.height))
            val p2 = Pair(Random.nextInt(Configuration.width), Random.nextInt(Configuration.height))
            val p3 = Pair(Random.nextInt(Configuration.width), Random.nextInt(Configuration.height))
            val color = Color(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))
            Triangle(listOf(p1, p2, p3), color)
        }
    }

    fun draw(graphics: Graphics) {
        graphics.color = Color.BLACK
        graphics.fillRect(0, 0, Configuration.width, Configuration.height)
        genes.forEach { gene -> gene.draw(graphics) }
    }

}