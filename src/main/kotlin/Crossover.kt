import shapes.Shape
import kotlin.random.Random

class Crossover {
    companion object {
        fun perform(pair: Pair<Individual, Individual>): DNA {
            val genes = (0 until Configuration.dnaSize).map { i ->
                val shape = if (i.rem(2) == 0) pair.first.dna.genes[i].copy() else pair.second.dna.genes[i].copy()
                if (Random.nextDouble() > Configuration.mutationProbability) {
                    shape
                } else {
                    shape.mutate()
                    shape
                }
            }
            return DNA(genes)
        }
    }
}
