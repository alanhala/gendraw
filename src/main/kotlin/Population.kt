import java.awt.Graphics
import java.awt.image.BufferedImage

class Population {
    var individuals: List<Individual>
    val fitnessFunction = FitnessFunction(Configuration.targetImage)

    val canvas: BufferedImage
    val graphics: Graphics

    constructor(canvas: BufferedImage, graphics: Graphics, dnaList: List<DNA>) {
        this.canvas = canvas
        this.graphics = graphics
        this.individuals = dnaList.map {
            it.draw(graphics)
            val fitness = fitnessFunction.compare(canvas)
            Individual(it, fitness)
        }.sortedByDescending { it.fitness }
    }

    fun fittest(): Individual {
        return individuals.first()
    }

    fun generateNewIndividuals(): List<DNA> {
        val newDnas = mutableListOf(fittest().dna)
        val fittests = individuals.subList(0, 10)
        (0 until (Configuration.populationSize - 2)).map {
            val pair = Pair(fittests.random(), fittests.random())
            newDnas.add(Crossover.perform(pair))
        }
        return newDnas
    }

    fun reachedMaxFittnes(): Boolean {
        return fittest().fitness >= fitnessFunction.maxFittnes()
    }
}