// Run at https://play.kotlinlang.org/

fun main() {
    assert(listOf(10, 15, 3, 7).sumToK(13))
    assert(listOf(6, 15, 3, 6).sumToK(12))
}

fun List<Int>.sumToK(k: Int): Boolean {
    val potentials = hashSetOf<Int>()
    forEach { num ->
        if (potentials.contains(num)) return true
        else potentials.add(k - num)
        
    }
    return false
}