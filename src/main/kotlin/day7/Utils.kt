package com.github.mvukic.day7

val cache = mutableMapOf<Int, List<List<String>>>()

data class Equation(
    val result: Long,
    val numbers: List<Long>,
    var hasValidFormula: Boolean = false
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

fun combinationsWithRepetition(items: List<String>, k: Int): List<List<String>> {
    if (cache.containsKey(k)) return cache[k]!!
    if (k == 0) return listOf(emptyList())
    val result = mutableListOf<List<String>>()
    for (item in items) {
        for (subCombination in combinationsWithRepetition(items, k - 1)) {
            result.add(listOf(item) + subCombination)
        }
    }
    cache[k] = result
    return result
}

fun createFormulas(numbers: List<Long>, operators: List<List<String>>): List<List<String>> {
    return operators.map { createFormula(numbers, it) }
}

fun createFormula(numbers: List<Long>, operators: List<String>): List<String> {
    val result = mutableListOf<String>()
    result.add(numbers[0].toString())
    for (i in 1 until numbers.size) {
        result.add(operators[i - 1].toString())
        result.add(numbers[i].toString())

    }
    return result
}

fun calculateFormulaPart1(formula: List<String>): Long {
    var result = formula[0].toLong()
    for (i in 1..formula.size - 1 step 2) {
        result = when (formula[i]) {
            "+" -> result + formula[i + 1].toLong()
            "*" -> result * formula[i + 1].toLong()
            else -> throw IllegalArgumentException("Invalid operator: ${formula[i]}")
        }
    }
    return result
}

fun calculateFormulaPart2(formula: List<String>): Long {
    var result = formula[0].toLong()
    for (i in 1..formula.size - 1 step 2) {
        result = when (formula[i]) {
            "+" -> result + formula[i + 1].toLong()
            "*" -> result * formula[i + 1].toLong()
            "||" -> "${result}${formula[i + 1]}".toLong()
            else -> throw IllegalArgumentException("Invalid operator: ${formula[i]}")
        }
    }
    return result
}
