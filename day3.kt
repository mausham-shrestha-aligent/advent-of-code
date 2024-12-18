import java.io.File
fun main() {
    val corruptedMemory = File("day3-input").readText()
    solvePart1(corruptedMemory)
    solvePart2(corruptedMemory)
}

fun solvePart1(content: String) {
    val regex = Regex("""mul\((\d+),(\d+)\)""")
    val matched = regex.findAll(content)
    var result = 0
    matched.forEach {
        val (num1, num2) = it.destructured
        result += num1.toInt() * num2.toInt()
    }

    println(result)
}

fun solvePart2(content: String) {
    val regex = Regex("""mul\((\d+),\s*(\d+)\)|do\(\)|don't\(\)""")
    val matched = regex.findAll(content)
    var result = 0
    var sum = true
    matched.forEach {
        if (it.value == "don't()") {
            sum = false
            return@forEach
        } else if (it.value == "do()") {
            sum = true
            return@forEach
        } else if (sum) {
            val (num1, num2) = it.destructured
            result += num1.toInt() * num2.toInt()
        }
    }

    println(result)
}
