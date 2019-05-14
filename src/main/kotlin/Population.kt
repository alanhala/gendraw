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
        return (0 until (Configuration.populationSize - 1)).map {
            val one = NaturalSelection().getParent(individuals)
            val two = NaturalSelection().getParent(individuals)
            val pair = Pair(one, two)
            Crossover.perform(pair)
        }
    }
}