// Run at play.kotlinlang.org
// I could not figure out the non division solution in 30 min.

fun main() {
    assert(
        productArray(intArrayOf(1,2,3,4,5)) 
        contentEquals 
        intArrayOf(120, 60, 40, 30, 24)
    )
    
    assert(
        productArray(intArrayOf(3, 2, 1)) 
        contentEquals 
        intArrayOf(2, 3, 6)
    )
}

// O(n) in the general sense but O(2n) in the pedantic sense
// for time because we iterate twice
// O(n) for space because create an array of equal size
fun productArray(input: IntArray): IntArray {
    val product = input.reduce { acc, i -> acc * i }
    return input.map { product / it }.toIntArray()
}

