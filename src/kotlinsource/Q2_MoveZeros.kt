package kotlinsource

fun main(args: Array<String>) {
    val nums = intArrayOf(0, 3, 2, 0, 8, 5)

    var index: Int = 0
    for (i in 0 until nums.size) {
        if (nums[i] != 0) {
            nums[index] = nums[i]
            index++
        }
    }

    while (index < nums.size) {
        nums[index] = 0
        index++
    }

    printNums(nums)
}

fun printNums(nums: IntArray) {
    nums.forEach { num -> print("$num ") }
}