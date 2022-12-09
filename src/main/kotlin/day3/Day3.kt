package day3

import java.io.File

private const val INPUT_FILE = "src/main/resources/input_day3.txt"
private const val FAKE_INPUT = "src/main/resources/fake_input"

fun main(args: Array<String>) {
    val inputFile = File(INPUT_FILE)
    val lines = inputFile.readLines()

    var prioritiesSum = 0
    var badgesPrioritiesSum = 0

    val linesIterator = lines.iterator()
    while (linesIterator.hasNext()) {
        val firstRucksack = Rucksack(linesIterator.next())
        val secondRucksack = Rucksack(linesIterator.next())
        val thirdRucksack = Rucksack(linesIterator.next())

        prioritiesSum += firstRucksack.repeatedItemPriority()
        prioritiesSum += secondRucksack.repeatedItemPriority()
        prioritiesSum += thirdRucksack.repeatedItemPriority()

        badgesPrioritiesSum += firstRucksack.repeatedItemPriorityBetweenRuckSacks(secondRucksack, thirdRucksack)
    }

    println("Priorities sum: $prioritiesSum")
    println("Badges Priorities sum: $badgesPrioritiesSum")
}
