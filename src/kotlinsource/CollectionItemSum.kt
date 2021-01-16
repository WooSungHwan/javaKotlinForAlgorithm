package kotlinsource

class CollectionItemSum {
    fun test(param: String): String {
        return param
    }
}

fun main(args: Array<String>) {
    val collectionItemSum = CollectionItemSum()
    val test = collectionItemSum.test("하하하하하")
    println(test)
}