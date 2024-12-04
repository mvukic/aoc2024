package com.github.mvukic.day4

fun verticalMirror(matrix: List<CharArray>): List<CharArray> {
    val rows = matrix.size
    val cols = matrix[0].size
    val mirrored = Array(rows) { CharArray(cols) }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            mirrored[rows - 1 - i][j] = matrix[i][j]
        }
    }

    return mirrored.toList()
}

fun swapRowsAndColumns(matrix: List<CharArray>): List<CharArray> {
    val rows = matrix.size
    val cols = matrix[0].size
    val swapped = Array(cols) { CharArray(rows) }

    for (i in 0 until cols) {
        for (j in 0 until rows) {
            swapped[i][j] = matrix[j][i]
        }
    }

    return swapped.toList()
}

fun getDiagonalValues(matrix: List<CharArray>): List<String> {
    val rows = matrix.size
    val cols = matrix[0].size
    val allDiagonalValues = mutableListOf<List<Char>>()

    // Get diagonals from top-left to bottom-right
    for (k in -rows + 1 until cols) {
        val diagonal = mutableListOf<Char>()
        for (i in 0 until rows) {
            val j = i + k
            if (j in 0 until cols) {
                diagonal.add(matrix[i][j])
            }
        }
        if (diagonal.isNotEmpty()) {
            allDiagonalValues.add(diagonal)
        }
    }

    return allDiagonalValues.map { it.joinToString("") }
}