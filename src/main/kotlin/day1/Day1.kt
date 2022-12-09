package day1

import java.io.File

private const val INPUT_FILE = "src/main/resources/input_day1.txt"

fun main(args: Array<String>) {
    val inputFile = File(INPUT_FILE)

    var topThree = TopThree()
    var current = 0

    inputFile.forEachLine {
        if (it.isEmpty()) {
            topThree = topThree.processContender(current)
            current = 0
        } else {
            current += it.toInt()
        }
    }

    println("Most calories: ${topThree.first}")
    println("Top three sum: ${topThree.sum()}")
}

