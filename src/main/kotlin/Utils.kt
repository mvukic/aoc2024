package com.github.mvukic

import java.io.File

fun linesForDay(day: Int) = File("src/main/kotlin/day$day", "input.txt").readLines()