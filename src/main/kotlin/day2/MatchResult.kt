package day2

import java.lang.IllegalArgumentException

enum class MatchResult(val value: Int) {
    WIN(6), DRAW(3), LOSE(0);

    companion object {
        fun from(key: String) = when(key) {
            "X" -> LOSE
            "Y" -> DRAW
            "Z" -> WIN
            else -> throw IllegalArgumentException("Unknown key: $key")
        }
    }
}