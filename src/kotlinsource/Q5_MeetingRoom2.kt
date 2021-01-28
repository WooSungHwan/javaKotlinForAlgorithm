package kotlinsource

import java.lang.Integer.max
import java.util.*

fun main(args:Array<String>) {
/*
    val int1:Interval = Interval(0, 30)
    val int2:Interval = Interval(15, 20)
    val int3:Interval = Interval(5, 10)

 */
/*
    val int1:Interval = Interval(1, 4)
    val int2:Interval = Interval(4, 5)
    val int3:Interval = Interval(4, 6)
*/


    val int1:Interval = Interval(2, 4)
    val int2:Interval = Interval(7, 10)


    val list = arrayOf(int1, int2)

    print(solve(list))

}

fun solve(intervals: Array<Interval>): Int {
    if (intervals == null || intervals.isEmpty()) return 0

    val intervals = intervals.sortedBy { it.start }

    val minHeap:Queue<Interval> = PriorityQueue<Interval>(intervals.size, compareBy { it.end })
    var max: Int = 0

    for (interval in intervals) {
        while(!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
            minHeap.poll();
        }
        minHeap.offer(interval)
        max = max(max, minHeap.size)
    }
    return max
}