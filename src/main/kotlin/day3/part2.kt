package com.github.mvukic.day3

import com.github.mvukic.linesForDay

fun main() {
    val mulRegex = "mul\\(([0-9]{1,3}),([0-9]{1,3})\\)".toRegex()
    val doRegex = "do\\(\\)".toRegex()
    val dontsRegex = "don't\\(\\)".toRegex()
    val lines = linesForDay(3)
    val line = "do()" + lines.joinToString(separator = "")
    val multiplications = mulRegex.findAll(line).toList().map { it.range.first to it.groupValues }
    val dos = doRegex.findAll(line).toList().map { it.range.first to it.groupValues }
    val donts = dontsRegex.findAll(line).toList().map { it.range.first to it.groupValues }
    val dosAndDonts = (dos + donts).sortedBy { it.first }
    val sum = multiplications
        .filter { isEnabled(dosAndDonts, it.first) }
        .sumOf { it.second[1].toInt() * it.second[2].toInt() }
    println(sum)
}

fun isEnabled(dosAndDonts: List<Pair<Int, List<String>>>, index: Int): Boolean {
    val doOrDont = dosAndDonts.findLast { it.first <= index }
    requireNotNull(doOrDont)
    return doOrDont.second.first() == "do()"
}