package com.github.mvukic.day4

import com.github.mvukic.linesForDay

fun main() {
    val regex = "XMAS".toRegex()
    val lines = linesForDay(4).map { it.toCharArray() }
    var count = 0

    println("Horizontal - left to right && right to left")
    var leftToRightCount = 0
    var rightToLeftCount = 0
    lines.forEach {
//        println(it)
        count += regex.findAll(it.joinToString("")).count()
        leftToRightCount += regex.findAll(it.joinToString("")).count()
        count += regex.findAll(it.joinToString("").reversed()).count()
        rightToLeftCount += regex.findAll(it.joinToString("").reversed()).count()
    }
    println("Count: $leftToRightCount")
    println("Count: $rightToLeftCount")



    println("\nVertical - top to bottom && bottom to top")
    var bottomToTopCount = 0
    var topToBottomCount = 0
    swapRowsAndColumns(lines).forEach {
//        println(it)
        count += regex.findAll(it.joinToString("")).count()
        bottomToTopCount += regex.findAll(it.joinToString("")).count()
        count += regex.findAll(it.joinToString("").reversed()).count()
        topToBottomCount += regex.findAll(it.joinToString("").reversed()).count()
    }
    println("Count: $bottomToTopCount")
    println("Count: $topToBottomCount")



    println("\nDiagonals - bottom-left to top-right && top-right to bottom-left")
    var diagonalsCount1 = 0
    var diagonalsCount2 = 0
    getDiagonalValues(lines).forEach {
//        println(it)
        count += regex.findAll(it).count()
        diagonalsCount1 += regex.findAll(it).count()
        count += regex.findAll(it.reversed()).count()
        diagonalsCount2 += regex.findAll(it.reversed()).count()
    }
    println("Count: $diagonalsCount1")
    println("Count: $diagonalsCount2")
    println("\nDiagonals - top-left to bottom-right && bottom-right to top-left")
    var diagonalsCount3 = 0
    var diagonalsCount4 = 0
    getDiagonalValues(verticalMirror(lines)).forEach {
//        println(it)
        count += regex.findAll(it).count()
        diagonalsCount3 += regex.findAll(it).count()
        count += regex.findAll(it.reversed()).count()
        diagonalsCount4 += regex.findAll(it.reversed()).count()
    }
    println("Count: $diagonalsCount3")
    println("Count: $diagonalsCount4")

    println("\nCount: $count")
}

