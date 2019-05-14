import junit.framework.Assert.assertEquals
import org.junit.Test
import java.awt.Color
import java.awt.image.BufferedImage

class FitnessFunctionTest {
    @Test
    fun completelyDifferentImageReturns0() {
        val image1 = BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB)
        val image2 = BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB)
        val g1 = image1.graphics
        val g2 = image2.graphics
        g1.color = Color.BLACK
        g1.fillRect(0, 0, 10, 10)

        g2.color = Color.WHITE
        g2.fillRect(0, 0, 10, 10)

        val fitness = FitnessFunction(image1).compare(image2)
        assertEquals(0.0, fitness)
    }

    @Test
    fun sameImageReturns1() {
        val image1 = BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB)
        val image2 = BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB)
        val g1 = image1.graphics
        val g2 = image2.graphics
        g1.color = Color.BLACK
        g1.fillRect(0, 0, 10, 10)

        g2.color = Color.BLACK
        g2.fillRect(0, 0, 10, 10)

        val fitness = FitnessFunction(image1).compare(image2)
        assertEquals(1.0, fitness)
    }

    @Test
    fun test() {
        val image1 = BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB)
        val image2 = BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB)
        val g1 = image1.graphics
        val g2 = image2.graphics
        g1.color = Color.BLACK
        g1.fillRect(0, 0, 10, 4)
        g1.color = Color.WHITE
        g1.fillRect(0, 5, 10, 10)

        g2.color = Color.BLACK
        g2.fillRect(0, 0, 10, 10)

        val fitness = FitnessFunction(image1).compare(image2)
        assertEquals(0.5, fitness)
    }
}