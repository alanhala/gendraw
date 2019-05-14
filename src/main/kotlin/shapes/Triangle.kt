package shapes

import java.awt.Color
import java.awt.Graphics
import kotlin.random.Random

data class Triangle(var vertices: List<Pair<Int, Int>>, var color: Color) : Shape {
    override fun draw(graphics: Graphics) {
        graphics.color = color
        graphics.fillPolygon(
            vertices.map { it.first }.toIntArray(),
            vertices.map { it.second }.toIntArray(),
            vertices.size
        )
    }

    override fun mutate() {
        if (Random.nextBoolean()) {
            val colorMutation = Random.nextInt(4)
            when (colorMutation) {
                0 -> color = Color(Utils.bound(color.red + Random.nextInt(Configuration.maxColorDelta) - Configuration.halfMaxColorDelta, 0, 255), color.green, color.blue, color.alpha)
                1 -> color = Color(color.red, Utils.bound(color.green + Random.nextInt(Configuration.maxColorDelta) - Configuration.halfMaxColorDelta, 0, 255), color.blue, color.alpha)
                2 -> color = Color(color.red, color.green, Utils.bound(color.blue + Random.nextInt(Configuration.maxColorDelta) - Configuration.halfMaxColorDelta, 0, 255), color.alpha)
                3 -> color = Color(color.red, color.green, color.blue, Utils.bound(color.alpha + Random.nextInt(Configuration.maxColorDelta) - Configuration.halfMaxColorDelta, 0, 255))
            }
        } else {
            val vertex = vertices.random()
            val newX = Utils.bound(vertex.first + Random.nextInt(Configuration.maxDelta) - Configuration.halfDelta, 0, Configuration.width)
            val newY = Utils.bound(vertex.second + Random.nextInt(Configuration.maxDelta) - Configuration.halfDelta, 0, Configuration.height)
            vertices = vertices.minus(vertex).plus(Pair(newX, newY))
        }
    }
}