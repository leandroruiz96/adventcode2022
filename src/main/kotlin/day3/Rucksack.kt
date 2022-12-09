package day3

import java.lang.IllegalStateException

class Rucksack(private val keyString: String) {

    private val itemsLeft = Array(52, init = {0})
    private val itemsRight = Array(52, init = {0})

    init {
        keyString.forEachIndexed { index, itemKey ->
            val item = Item(itemKey)

            if (index < keyString.length / 2) {
                itemsLeft[item.priority - 1] += 1
            } else {
                itemsRight[item.priority - 1] += 1
            }
        }
    }

    fun repeatedItemPriority(): Int {
        for (index in 0 until 52)
            if (hasItemOnLeftCompartmentAt(index) &&
                hasItemOnRightCompartmentAt(index))
                return index + 1

        throw IllegalStateException("No repeated item found")
    }

    fun repeatedItemPriorityBetweenRuckSacks(second: Rucksack, third: Rucksack): Int {
        for (index in 0 until 52)
            if (this.hasItemAt(index) && second.hasItemAt(index) && third.hasItemAt(index))
                return index + 1

        throw IllegalStateException("No repeated item found")
    }

    private fun hasItemAt(index: Int) = hasItemOnLeftCompartmentAt(index) || hasItemOnRightCompartmentAt(index)

    private fun hasItemOnLeftCompartmentAt(index: Int) = itemsLeft[index] > 0
    private fun hasItemOnRightCompartmentAt(index: Int) = itemsRight[index] > 0
}