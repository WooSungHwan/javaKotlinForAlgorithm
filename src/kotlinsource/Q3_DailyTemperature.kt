package kotlinsource

import java.util.*

fun main(args: Array<String>) {
    val nums = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    val dailyTemperatures = dailyTemperatures(nums)

    println(dailyTemperatures.asList().toString())
}

fun dailyTemperatures(nums:IntArray):IntArray {

    val stack:Stack<Int> = Stack()
    val result:IntArray = IntArray(nums.size)

    for (i in nums.indices) {
        while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
            val index = stack.pop()
            result[index] = i - index
        }
        stack.push(i);
    }

    return result
}