package com.github.mvukic.day1

import com.github.mvukic.linesForDay
import kotlin.math.abs

fun main() {
    val lines = linesForDay(1)
    val pairs = lines.map { it.split("\\s+".toRegex()) }
    val left = pairs.map { it[0].toInt() }.sorted()
    val right = pairs.map { it[1].toInt() }.sorted()
    val distances = left.zip(right).map { abs(it.first - it.second) }
    val sum = distances.sum()
    println(sum)
}