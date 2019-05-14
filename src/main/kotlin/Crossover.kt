import kotlin.random.Random

class Crossover {
    companion object {
        fun perform(pair: Pair<Individual, Individual>): DNA {
            val genes = (0 until Configuration.dnaSize).map { i ->
                val shape = if (Random.nextBoolean()) pair.first.dna.genes[i] else pair.second.dna.genes[i]
                if (Random.nextDouble() < 0.001) {
                    shape.mutate()
                }
                shape
            }
            return DNA(genes)
        }
    }
}