package day2

import java.io.File

private const val INPUT_FILE = "src/main/resources/input_day2.txt"
private const val FAKE_INPUT = "src/main/resources/fake_input"

fun main(args: Array<String>) {
    val inputFile = File(INPUT_FILE)

    var misinterpretedStrategyTotalScore = 0
    var elfStrategyTotalScore = 0

    inputFile.forEachLine {
        val pair = it.split(" ")

        val misinterpretedGame = Game(
            elfPlay = Play.from(pair[0]),
            humanPlay = Play.from(pair[1])
        )

        val strategyGame = Game(
            elfPlay = Play.from(pair[0]),
            expectedMatchResult = MatchResult.from(pair[1])
        )

        misinterpretedStrategyTotalScore += misinterpretedGame.calculateMatchScore()
        elfStrategyTotalScore += strategyGame.calculateMatchScore()
    }

    println("Misinterpreted Strategy total score: $misinterpretedStrategyTotalScore")
    println("Elf Strategy total score: $elfStrategyTotalScore")
}

