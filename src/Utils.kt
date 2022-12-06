import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * Splits this collection into a list of lists according to given [predicate] with [valueTransform] function applied to each element of the original collection
 */
inline fun <T, V> Iterable<T>.chunkedWithPredicate(predicate: (T) -> Boolean, valueTransform: (T) -> V): List<List<V>> {
    val list: MutableList<MutableList<V>> = ArrayList()
    var chunk = mutableListOf<V>()
    for (element in this) {
        if (predicate(element)) {
            if (chunk.isNotEmpty()) {
                list.add(chunk)
            }
            chunk = mutableListOf()
        } else
            chunk.add(valueTransform(element))
    }
    if (chunk.isNotEmpty()) {
        list.add(chunk)
    }
    return list
}

/**
 * Splits this collection into a list of lists according to given [predicate]
 */
inline fun <T> Iterable<T>.chunkedWithPredicate(predicate: (T) -> Boolean): List<List<T>> {
    val list: MutableList<MutableList<T>> = ArrayList()
    var chunk = mutableListOf<T>()
    for (element in this) {
        if (predicate(element)) {
            if (chunk.isNotEmpty()) {
                list.add(chunk)
            }
            chunk = mutableListOf()
        } else
            chunk.add(element)
    }
    if (chunk.isNotEmpty()) {
        list.add(chunk)
    }
    return list
}
