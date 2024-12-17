import java.io.File
import kotlin.math.absoluteValue

fun main() {
    val csvFile = File("day2-input.csv").readLines();
    var safeReportsCount = 0;
    csvFile.forEach {
        val temp = it.split(' ').map { item -> item.toInt() }
        if (canBeMadeSafe(temp)) {
            safeReportsCount++
        }
    }

    print(safeReportsCount)
}

fun isSafeSequence(levels: List<Int>): Boolean {
    val increasing = levels[1] > levels[0]
    for (i in 0 until levels.size - 1) {
        val current = levels[i]
        val next = levels[i + 1]
        val difference = next - current

        if (
                current == next ||
                difference.absoluteValue > 3 ||
                (increasing && next < current) ||
                (!increasing && next > current)
        ) {
            return false
        }
    }
    return true
}

fun canBeMadeSafe(levels: List<Int>): Boolean {
    if (isSafeSequence(levels)) return true

    for (i in levels.indices) {
        val modifiedLevels = levels.toMutableList().apply { removeAt(i) }
        if (isSafeSequence(modifiedLevels)) {
            return true
        }
    }

    return false
}
