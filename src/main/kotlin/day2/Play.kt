package day2

import java.lang.IllegalArgumentException

sealed class Play(val value: Int) {

    abstract fun matchResultAgainst(other: Play): MatchResult
    abstract fun playToGet(expectedMatchResult: MatchResult): Play

    object Rock: Play(value = 1) {
        override fun matchResultAgainst(other: Play): MatchResult = when (other) {
            Rock -> MatchResult.DRAW
            Paper -> MatchResult.LOSE
            Scissors -> MatchResult.WIN
        }

        override fun playToGet(expectedMatchResult: MatchResult) = when (expectedMatchResult) {
            MatchResult.DRAW -> Rock
            MatchResult.LOSE -> Scissors
            MatchResult.WIN -> Paper
        }
    }
    object Paper: Play(value = 2) {
        override fun matchResultAgainst(other: Play): MatchResult = when (other) {
            Rock -> MatchResult.WIN
            Paper -> MatchResult.DRAW
            Scissors -> MatchResult.LOSE
        }

        override fun playToGet(expectedMatchResult: MatchResult) = when (expectedMatchResult) {
            MatchResult.DRAW -> Paper
            MatchResult.LOSE -> Rock
            MatchResult.WIN -> Scissors
        }
    }
    object Scissors: Play(value = 3) {
        override fun matchResultAgainst(other: Play): MatchResult = when (other) {
            Rock -> MatchResult.LOSE
            Paper -> MatchResult.WIN
            Scissors -> MatchResult.DRAW
        }

        override fun playToGet(expectedMatchResult: MatchResult) = when (expectedMatchResult) {
            MatchResult.DRAW -> Scissors
            MatchResult.LOSE -> Paper
            MatchResult.WIN -> Rock
        }
    }

    companion object {
        fun from(key: String) = when (key) {
            "A", "X" -> Rock
            "B", "Y" -> Paper
            "C", "Z" -> Scissors
            else -> throw IllegalArgumentException("Unknown key: $key")
        }
    }
}