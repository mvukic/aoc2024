package com.github.mvukic.day2

import kotlin.math.abs


fun isReportSafe(levels: List<Int>): Boolean {
    return (isDecreasing(levels) || isIncreasing(levels)) && hasAllowedDiffer(levels)
}

fun isDecreasing(levels: List<Int>): Boolean {
    return levels.windowed(2).all { it[0] > it[1] }
}

fun isIncreasing(levels: List<Int>): Boolean {
    return levels.windowed(2).all { it[0] < it[1] }
}

fun hasAllowedDiffer(levels: List<Int>): Boolean {
    return levels.windowed(2).all { abs(it[0] - it[1]) >= 1 && abs(it[0] - it[1]) <= 3 }
}

fun hasSafePermutations(report: List<Int>): Boolean {
    return report.indices
        .map { index -> getReportWithoutLevelAt(report, index) }
        .any { report -> isReportSafe(report) }
}

fun getReportWithoutLevelAt(report: List<Int>, index: Int): List<Int> {
    return report.filterIndexed { i, _ -> i != index }
}