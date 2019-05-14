import java.awt.Color
import java.awt.image.BufferedImage
import kotlin.math.pow

class FitnessFunction(val target: BufferedImage) {
    fun compare(image: BufferedImage): Double {
        var distance = 0.0
        (0 until target.width).forEach { x ->
            (0 until target.height).forEach { y ->
                val color1 = Color(target.getRGB(x, y))
                val color2 = Color(image.getRGB(x, y))
                val diffRed = color1.red - color2.red
                val diffGreen = color1.green - color2.green
                val diffBlue = color1.blue - color2.blue

                distance += Math.abs(diffRed) + Math.abs(diffGreen) + Math.abs(diffBlue)
            }
        }
        val max = target.width.toLong() * target.height.toLong() * 3 * 255
        return (max - distance)/max
    }
}