package dijkstra

fun SimpleDijkstraLines() : String {
    // a 노드에서 b 노드로 가는 비용이 c 이다.
    return """
        1 2 2
        1 3 5
        1 4 1
        2 3 3
        2 4 2
        3 2 3
        3 6 5
        4 3 3
        4 5 1
        5 3 1
        5 6 2
    """.trimIndent()
}