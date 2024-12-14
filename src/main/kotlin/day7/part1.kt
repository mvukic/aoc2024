package com.github.mvukic.day7

import com.github.mvukic.linesForDay
import com.google.common.collect.Sets

fun main() {
    val lines = linesForDay(7)

    val equations = lines.map { Equation.fromString(it) }

    for (equation in equations) {
        println(equation)
        println(Sets.combinations(setOf('*', '+'), equation.numbers.size - 1))
    }

}


data class Equation(
    val result: Long,
    val numbers: List<Long>
) {

    companion object {
        fun fromString(input: String): Equation {
            val parts = input.split("\\s+".toRegex())
            return Equation(
                result = parts.first().dropLast(1).toLong(),
                numbers = parts.drop(1).map { it.toLong() }
            )
        }
    }

}