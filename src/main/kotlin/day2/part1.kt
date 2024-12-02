package com.github.mvukic.day2

import com.github.mvukic.linesForDay

fun main() {
    val lines = linesForDay(2)
    val reports = lines
        .map { report -> report.split("\\s+".toRegex()).map { it.toInt() } }

    val safeReports = reports.filter { isReportSafe(it) }
    println(safeReports.size)
}
