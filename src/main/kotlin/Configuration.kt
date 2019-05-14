import java.awt.image.BufferedImage
import javax.imageio.ImageIO

object Configuration {
    val dnaSize = 100
    val populationSize = 20
    val targetImage = ImageIO.read(Thread.currentThread().contextClassLoader.getResource("square.png"))
    val width = targetImage.width
    val height = targetImage.height

    // for moving/size
    val maxDelta = ((width + height) / 2) / 2
    val halfDelta = maxDelta / 2 + 2
    // for color
    val maxColorDelta = 100
    val halfMaxColorDelta = maxColorDelta / 2
}