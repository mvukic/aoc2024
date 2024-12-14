package com.github.mvukic.day6

import com.github.mvukic.linesForDay

fun main() {
    val lines = linesForDay(6).map { it.toCharArray().map { char -> GridItem(0, char) }.toTypedArray() }.toTypedArray()

    val height = lines.size
    val width = lines[0].size

    val guard = findInitialPosition(lines)
    lines[guard.row][guard.column].value = '.'
    while (true) {
        // Stop if the guard is out of the mapped area
        if (guard.column >= width || guard.row >= height) {
            break
        }

        // Increment visit count
        lines[guard.row][guard.column].visitCount++

        // Find next position
        val (nextRow, nextColumn) = when (guard.orientation) {
            '^' -> guard.row - 1 to guard.column
            '>' -> guard.row to guard.column + 1
            'v' -> guard.row + 1 to guard.column
            '<' -> guard.row to guard.column - 1
            else -> error("Unknown orientation")
        }

        // Stop if the guard is out of the mapped area
        if (nextColumn >= width || nextColumn < 0 || nextRow >= height || nextRow < 0) {
            break
        }
        // Path is blocked so change orientation
        if (lines[nextRow][nextColumn].value == '#') {
            guard.orientation = when (guard.orientation) {
                '^' -> '>'
                '>' -> 'v'
                'v' -> '<'
                '<' -> '^'
                else -> error("Unknown orientation")
            }
        }
        // Path is not blocked so move to next position
        if (lines[nextRow][nextColumn].value == '.') {
            guard.row = nextRow
            guard.column = nextColumn
        }
    }

    val distinctAreas = lines.sumOf { items -> items.filter { it.visitCount > 0 }.size }
    println(distinctAreas)

}

fun findInitialPosition(lists: Array<Array<GridItem>>): Guard {
    val startingPosition = listOf('^', '>', 'v', '<')
    for (rowIndex in lists.indices) {
        for (columnIndex in lists[rowIndex].indices) {
            val item = lists[rowIndex][columnIndex]
            if (item.value in startingPosition) {
                return Guard(rowIndex, columnIndex, item.value)
            }
        }
    }
    error("Starting position not found")
}


data class GridItem(var visitCount: Int, var value: Char)
data class Guard(var row: Int, var column: Int, var orientation: Char)