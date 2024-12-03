package com.github.mvukic.day3

import com.github.mvukic.linesForDay

fun main() {
    val regex = "mul\\(([0-9]{1,3}),([0-9]{1,3})\\)".toRegex()
    val lines = linesForDay(3)
    val line = lines.joinToString(separator = "")
    val multiplications = regex.findAll(line).toList()
    multiplications.forEach { println(it.groupValues)  }
    val sum = multiplications.sumOf { it.groupValues[1].toInt() * it.groupValues[2].toInt() }
    println(sum)
}