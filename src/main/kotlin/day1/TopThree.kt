package day1

data class TopThree constructor(
    val first: Int = 0,
    val second: Int = 0,
    val third: Int = 0
) {
    fun processContender(calories: Int): TopThree = when {
        calories > first -> copy(first = calories, second = first, third = second)
        calories > second -> copy(first = first, second = calories, third = second)
        calories > third -> copy(first = first, second = second, third = calories)
        else -> this
    }

    fun sum() = first + second + third
}