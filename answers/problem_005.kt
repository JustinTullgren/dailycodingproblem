/*
	Run at play.kotlinlang.org
	The question was asking for a functional concept answer
	so I wrote the higher order function using kotlin 
	functional types. I however think the type system
	makes it very terse and hard to read when returning
	functions from functions.
*/
import java.util.*

fun main() {
	assert(car(cons(3,4)) == 3)
  assert(cdr(cons(3,4)) == 4)
}

val cons = { a:Any, b:Any ->
    { f: (Any, Any) -> Any ->
        f(a,b)
    }
}

val car = { pair: ((Any, Any) -> Any) -> Any -> pair { a, b -> a } }
val cdr = { pair: ((Any, Any) -> Any) -> Any -> pair { a, b -> b } }