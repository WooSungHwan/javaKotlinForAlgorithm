package kotlinsource

import java.util.*


fun main(args:Array<String>) {
    val interval1 = Interval(1, 3)
    val interval2 = Interval(2, 6)
    val interval5 = Interval(7, 9)
    val interval3 = Interval(8, 10)
    val interval6 = Interval(10, 11)
    val interval4 = Interval(15, 18)
    val interval7 = Interval(17, 20)
    val interval8 = Interval(18, 20)

    val list:List<Interval> = listOf(interval1, interval2, interval3, interval4, interval5, interval6, interval8, interval7);

    println(merge(list))
}

fun merge(intervals:List<Interval>):List<Interval> {
    if(intervals.isEmpty()) return intervals

    val intervals = intervals.sortedBy { it.start }
    var result = ArrayList<Interval>();
    var before:Interval = intervals.get(0)
    for (i in 1..intervals.size - 1) {
        var current = intervals.get(i)
        if (before.end >= current.start) {
            before.end = current.end;
        } else {
            result.add(before)
            before = current
        }
    }

    if (!result.contains(before)) {
        result.add(before)
    }
    return result
}