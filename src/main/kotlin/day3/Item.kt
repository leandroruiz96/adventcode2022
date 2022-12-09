package day3

class Item(key: Char) {

    val priority = if (key.isLowerCase()) {
        key.code - 96
    } else {
        key.code - 64 + 26
    }

}