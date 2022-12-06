fun main() {
    fun Pair<String, String>.getRoundScore(): Int {
        return when {
            //Rock & Rock -> Draw
            first == "A" && second == "X" -> 1 + 3
            //Rock & Paper -> Win
            first == "A" && second == "Y" -> 2 + 6
            //Rock & Scissors -> Loss
            first == "A" && second == "Z" -> 3 + 0
            //Paper & Rock -> Loss
            first == "B" && second == "X" -> 1 + 0
            //Paper & Paper -> Draw
            first == "B" && second == "Y" -> 2 + 3
            //Paper & Scissors -> Win
            first == "B" && second == "Z" -> 3 + 6
            //Scissors & Rock -> Win
            first == "C" && second == "X" -> 1 + 6
            //Scissors & Paper -> Loss
            first == "C" && second == "Y" -> 2 + 0
            //Scissors & Scissors -> Draw
            first == "C" && second == "Z" -> 3 + 3
            else -> 0
        }
    }

    fun Pair<String, String>.getNewMove(): Pair<String, String> {
        return when (second) {
            "X" -> {
                first to when (first) {
                    "A" -> "Z"
                    "B" -> "X"
                    else -> "Y"
                }
            }
            "Y" -> first to when (first) {
                "A" -> "X"
                "B" -> "Y"
                else -> "Z"
            }
            "Z" -> first to when (first) {
                "A" -> "Y"
                "B" -> "Z"
                else -> "X"
            }
            else -> this
        }
    }

    fun List<String>.getInputInPairs(): List<Pair<String, String>> = map { round ->
        val roundValues = round.split(" ")
        roundValues.first() to roundValues.last()
    }

    fun part1(input: List<String>): Int {
        val data = input.getInputInPairs()
        return data.sumOf {
            it.getRoundScore()
        }
    }

    fun part2(input: List<String>): Int {
        val data = input.getInputInPairs()
        return data.sumOf { it.getNewMove().getRoundScore() }
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
