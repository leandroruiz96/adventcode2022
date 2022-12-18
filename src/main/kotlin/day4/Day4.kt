package day4

import java.io.File


private const val INPUT_FILE = "src/main/resources/input_day4.txt"
private const val FAKE_INPUT = "src/main/resources/fake_input"

fun main(args: Array<String>) {
    val inputFile = File(INPUT_FILE)
    val lines = inputFile.readLines()

    var completelyIncludedPairs = 0
    var overlappingPairs = 0

    val linesIterator = lines.iterator()
    while (linesIterator.hasNext()) {
        val edges = linesIterator.next()
            .split(",", "-")
            .map { it.toInt() }

        val firstElfRange = edges[0]..edges[1]
        val secondElfRange = edges[2]..edges[3]

        if (firstElfRange in secondElfRange || secondElfRange in firstElfRange) {
            completelyIncludedPairs++
        }

        if (firstElfRange.overlaps(secondElfRange)) overlappingPairs++
    }

    println("Completely included pairs: $completelyIncludedPairs")
    println("Overlapping pairs: $overlappingPairs")

}

private operator fun IntRange.contains(other: IntRange): Boolean = this.first <= other.first && this.last >= other.last

private fun IntRange.overlaps(other: IntRange): Boolean = this.first in other || this.last in other || other.first in this || other.last in this