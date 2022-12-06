fun main() {
    fun List<List<Int>>.sortedNElementsSum(n: Int): Int {
        val values = sortedSetOf<Int>()
        for (element in map { it.sum() }) {
            values.add(element)
            if (values.size > n) {
                values.remove(values.first())
            }
        }
        return values.sum()
    }

    fun part1(input: List<String>): Int {
        val data = input.chunkedWithPredicate(
            predicate = { it.isBlank() },
            valueTransform = { it.toInt() }
        )
        return data.maxOf { it.sum() }
    }

    fun part2(input: List<String>): Int {
        val data = input.chunkedWithPredicate(
            predicate = { it.isBlank() },
            valueTransform = { it.toInt() }
        )
        return data.sortedNElementsSum(3)
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
