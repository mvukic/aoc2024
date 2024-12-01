package com.github.mvukic.day1

import com.github.mvukic.linesForDay

fun main() {
    val lines = linesForDay(1)
    val pairs = lines.map { it.split("\\s+".toRegex()) }
    val left = pairs.map { it[0].toInt() }
    val right = pairs.map { it[1].toInt() }.groupingBy { it }.eachCount()
    val distances = left.map { it * (right[it] ?: 0) }
    val sum = distances.sum()
    println(sum)
}