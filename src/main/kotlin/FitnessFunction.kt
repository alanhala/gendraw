import java.awt.Color
import java.awt.image.BufferedImage
import kotlin.math.pow

class FitnessFunction(val target: BufferedImage) {
    fun compare(image: BufferedImage): Int {
        var distance = 0
        (0 until target.width step 2).forEach { x ->
            (0 until target.height step 2).forEach { y ->
                val color1 = Color(target.getRGB(x, y))
                val color2 = Color(image.getRGB(x, y))
                val diffRed = Math.abs(color1.red - color2.red)
                val diffGreen = Math.abs(color1.green - color2.green)
                val diffBlue = Math.abs(color1.blue - color2.blue)

                distance += diffRed + diffGreen + diffBlue
            }
        }

        return maxFittnes() - distance
    }

    fun maxFittnes(): Int {
        return target.width * target.height * 3 * 255
    }
}