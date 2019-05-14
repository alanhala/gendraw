import kotlin.random.Random

class NaturalSelection {
    fun getParent(population: List<Individual>): Individual {
        val bias = population.size * 0.6
        var i = 0
        population.forEach { individual ->
            if (i > 0) {
                if (Random.nextDouble() <= (population.size - i) / (population.size.toDouble() + bias)) {
                    return individual
                }
            }
            i++
        }
        return population.first()
    }
}