import java.awt.Color
import java.awt.Graphics
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

fun main(args: Array<String>) {
    GeneticDraw().start()
}

class GeneticDraw {
    val fittestCanvas = BufferedImage(Configuration.width, Configuration.height, BufferedImage.TYPE_INT_ARGB)
    val fittestGraphics = fittestCanvas.graphics

    val testCanvas = BufferedImage(Configuration.width, Configuration.height, BufferedImage.TYPE_INT_ARGB)
    val testGraphics = testCanvas.graphics

    var dnaList = (0 until Configuration.populationSize).map { DNA() }

    var population: Population? = null

    fun start() {
        val frame = JFrame()
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.setSize(Configuration.width, Configuration.height)
        frame.isVisible = true

        val panel = object : JPanel() {
            override fun paintComponent(g: Graphics) {
                super.paintComponent(g)
                population?.let {
                    it.fittest().dna.draw(fittestGraphics)
                    g.drawImage(fittestCanvas, 0, 0, Configuration.width, Configuration.height, this)
                }
            }
        }

        frame.add(panel)
        panel.revalidate()

        var i = 0

        while (true) {
            population = Population(testCanvas, testGraphics, dnaList)

            println("$i, ${population!!.fittest().fitness}")

            panel.repaint()

            dnaList = population!!.generateNewIndividuals()
            i++
        }
    }
}