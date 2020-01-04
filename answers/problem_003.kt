// Run at play.kotlinlang.org

import java.util.*

fun main() {
    val node = Node("root", Node("left", Node("left.left")), Node("right"))
    val serializedNode = serialize(node)
    assert(deserialize(serializedNode)?.left?.left?.value == "left.left")
}
data class Node(val value: String, var left: Node? = null, var right: Node? = null)

const val nil = "_"

fun serialize(node: Node?): String {
    if (node == null) {
        return "${nil}-"
    }
    
    var result = "${node.value}-"
    result += serialize(node.left)
    result += serialize(node.right)
    
    return result
}

fun deserialize(value: String?): Node? {
    if(value == null) return null
    return deserialize(ArrayDeque(value.split("-")))
}

fun deserialize(nodes: Queue<String>): Node? {
    if (nodes.peek() != null) {
        val nodeValue = nodes.poll()
        if (nodeValue == nil) return null
        val node = Node(nodeValue)
        node.left = deserialize(nodes)
        node.right = deserialize(nodes)
        return node
    }
    return null
}
