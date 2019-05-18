package shapes

import java.awt.Color
import java.awt.Graphics
import kotlin.random.Random

class Ellipse(var x: Int, var y: Int, var width: Int, var height: Int, var color: Color) : Shape {
    override fun copy(): Shape {
        return Ellipse(x, y, width, height, color)
    }

    override fun draw(graphics: Graphics) {
        graphics.color = color
        graphics.fillOval(x, y, width, height)
    }

    override fun mutate() {
        val mutationType = Random.nextInt(8)
        when (mutationType) {
            0 -> x = Utils.bound(
                x + Random.nextInt(Configuration.maxDelta) - Configuration.halfDelta,
                0,
                Configuration.width - width
            )
            1 -> y = Utils.bound(
                y + Random.nextInt(Configuration.maxDelta) - Configuration.halfDelta,
                0,
                Configuration.height - height
            )
            2 -> width = Utils.bound(
                width + Random.nextInt(Configuration.maxDelta) - Configuration.halfDelta,
                5,
                Configuration.width
            )
            3 -> height = Utils.bound(
                height + Random.nextInt(Configuration.maxDelta) - Configuration.halfDelta,
                5,
                Configuration.height
            )
            4 -> color = Color(
                Utils.bound(
                    color.red + Random.nextInt(Configuration.maxColorDelta) - Configuration.halfMaxColorDelta,
                    0,
                    255
                ), color.green, color.blue, color.alpha
            )
            5 -> color = Color(
                color.red,
                Utils.bound(
                    color.green + Random.nextInt(Configuration.maxColorDelta) - Configuration.halfMaxColorDelta,
                    0,
                    255
                ),
                color.blue,
                color.alpha
            )
            6 -> color = Color(
                color.red,
                color.green,
                Utils.bound(
                    color.blue + Random.nextInt(Configuration.maxColorDelta) - Configuration.halfMaxColorDelta,
                    0,
                    255
                ),
                color.alpha
            )
            7 -> color = Color(
                color.red,
                color.green,
                color.blue,
                Utils.bound(
                    color.alpha + Random.nextInt(Configuration.maxColorDelta) - Configuration.halfMaxColorDelta,
                    0,
                    255
                )
            )
        }
    }
}