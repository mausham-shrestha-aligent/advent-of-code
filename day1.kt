import java.io.File;
import kotlin.math.absoluteValue

fun main() {
    val csvFile = File("location-id.csv").readLines();
    val first = ArrayList<Int>();
    val second = ArrayList<Int>();
    csvFile.forEach {
        val (f, s) = it.split(',');
        first.add(f.toInt());
        second.add(s.toInt());
    }

    getTotalDistanceBetweenLists(first, second);
    getSimilarityScore(first, second);
}

fun getTotalDistanceBetweenLists(first: ArrayList<Int>, second: ArrayList<Int>) {
    var sum = 0;
    first.forEachIndexed { index, element ->
        sum += (element - second[index]).absoluteValue;
    }

    println("Total Distance Between Lists: $sum")
}

fun getSimilarityScore(first: ArrayList<Int>, second: ArrayList<Int>) {
    var similarityScore = 0;
    val elementFromFirstArrayOccurrenceInSecondArray: HashMap<Int, Int> = hashMapOf();
    first.forEach {
        var count = 0;
        for (i in 0 until second.size - 1) {
            if (second[i] == it) {
                count++
            }
        }
        elementFromFirstArrayOccurrenceInSecondArray[it] = count;
    }

    elementFromFirstArrayOccurrenceInSecondArray.forEach {
        similarityScore += it.key * it.value
    }

    println("Similarity score: $similarityScore")
}


