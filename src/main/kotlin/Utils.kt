package com.github.mvukic

import java.io.File

fun linesForDay(day: Int) = File("src/main/kotlin/day$day", "input.txt").readLines()

fun main() {
    for (day in 5..8) createDayPackage(day)
}

fun createDayPackage(day: Int) {
    val directory = File("./src/main/kotlin/day$day")
    if (!directory.exists()) {
        directory.mkdirs()
    }
    val dayContent = """
        package com.github.mvukic.day$day

        import com.github.mvukic.linesForDay

        fun main() {
            val lines = linesForDay($day)
        }
    """.trimIndent()
    val inputFile = File("./src/main/kotlin/day$day", "input.txt")
    if (!inputFile.exists()) {
        inputFile.createNewFile()
    }
    val part1File = File("./src/main/kotlin/day$day", "part1.kt")
    if (!part1File.exists()) {
        part1File.createNewFile()
        part1File.writeText(dayContent)
    }
    val part2File = File("./src/main/kotlin/day$day", "part2.kt")
    if (!part2File.exists()) {
        part2File.createNewFile()
        part2File.writeText(dayContent)
    }
}

data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int
)

fun <T> T.satisfiesAll(vararg conditions: T.() -> Boolean): Boolean {
    return conditions.all { condition -> condition(this) }
}

fun <T> T.satisfiesOne(vararg conditions: T.() -> Boolean): Boolean {
    return conditions.any { condition -> condition(this) }
}
//
//fun main() {
//    val person = Person("John", "Doe", 30)
//    if (person.age >= 18 && person.firstName == "John") {
//        println("Adult and name John")
//    }
//    if (person.satisfiesAll({ age >= 18 }, { firstName == "John" })) {
//        println("Adult and name John")
//    }
//}