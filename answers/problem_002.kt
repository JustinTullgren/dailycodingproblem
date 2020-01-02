// Run at play.kotlinlang.org
// I could not figure out the non division solution in 30 min.
// Things I forgot to think about were division by 0.
// I could have done the brute force O(n^2) but didn't think
// that was what they were looking for. 
// (nested loops multiply excluding the current index)

import java.util.*

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
    
    assert(
        productArrayNoDivision(intArrayOf(1,2,3,4,5)) 
        contentEquals 
        intArrayOf(120, 60, 40, 30, 24)
    )
    
    assert(
        productArrayNoDivision(intArrayOf(3, 2, 1)) 
        contentEquals 
        intArrayOf(2, 3, 6)
    )
    
}

// O(n) for time & space, no checks for division by 0
fun productArray(input: IntArray): IntArray {
    val product = input.reduce { acc, i -> acc * i }
    return input.map { product / it }.toIntArray()
}

fun productArrayNoDivision(input: IntArray): IntArray {
   val result = LinkedList<Int>()
   var right = 1
   input.reversed().forEach {
       result.push(right)
       right *= it
   }
   var left = 1
   input.forEachIndexed { index, i -> 
       result[index] *= left
       left *= i
   }
   return result.toIntArray()
}





