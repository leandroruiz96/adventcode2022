package day2

data class Game(
    val elfPlay: Play,
    val humanPlay: Play
) {

    constructor(elfPlay: Play, expectedMatchResult: MatchResult) : this(
        elfPlay = elfPlay,
        humanPlay = elfPlay.playToGet(expectedMatchResult)
    )

    fun calculateMatchScore() = humanPlay.matchResultAgainst(elfPlay).value  + humanPlay.value
}