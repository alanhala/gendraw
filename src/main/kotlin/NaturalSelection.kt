import kotlin.random.Random

class NaturalSelection {
    fun getParent(population: List<Individual>): Individual {
        val sum = population.sumBy { it.fitness }
        val populationWithProbability = population.map { Pair(it, it.fitness.toDouble() / sum.toDouble()) }
        var index = 0
        var r = Random.nextDouble()

        while (r > 0) {
            r -= populationWithProbability[index].second
            index++
        }
        index--
        return populationWithProbability[index].first
    }
}