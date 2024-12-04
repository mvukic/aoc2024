package com.github.mvukic.day4

import com.github.mvukic.linesForDay

fun main() {
    val lines = linesForDay(4).map { it.toCharArray() }
}

fun countSubmatrixOccurrences(matrix: Array<CharArray>, submatrix: Array<CharArray>): Int {
    val rows = matrix.size
    val cols = matrix[0].size
    val subRows = submatrix.size
    val subCols = submatrix[0].size
    var count = 0

    for (i in 0 until rows - subRows + 1) {
        for (j in 0 until cols - subCols + 1) {
            var found = true
            for (k in 0 until subRows) {
                for (l in 0 until subCols) {
                    if (matrix[i + k][j + l] != submatrix[k][l]) {
                        found = false
                        break
                    }
                }
                if (!found) {
                    break
                }
            }
            if (found) {
                count++
            }
        }
    }
    return count
}