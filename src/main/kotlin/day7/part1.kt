package com.github.mvukic.day7

import com.github.mvukic.linesForDay


fun main() {
    val lines = linesForDay(7)
    val operators = listOf("*", "+")

    val equations = lines.map { Equation.fromString(it) }

    for (equation in equations) {
        val operatorCombinations = combinationsWithRepetition(operators, equation.numbers.size - 1)
        val formulas = createFormulas(equation.numbers, operatorCombinations)
        equation.hasValidFormula = formulas.any { calculateFormulaPart1(it) == equation.result }
    }

    val result = equations.filter { it.hasValidFormula }.sumOf { it.result }
    println(result)

}