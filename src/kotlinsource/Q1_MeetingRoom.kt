package kotlinsource

import java.util.*

class Q1_MeetingRoom {
    fun solve(intervals: Array<Interval>): Boolean {
        Arrays.sort(intervals, Comparator { o1, o2 ->  o1.start - o2.end})
        for(i in 1 until intervals.size) {
            if (intervals[i].start <= intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

    fun print(intervals: Array<Interval>) {
        intervals.forEach { interval -> println(interval.toString()) }
    }

}

class Interval (var start:Int, var end:Int) {

    public override fun toString(): String {
        return String.format("start = %s, end = %s", start, end)
    }
}

fun main(args: Array<String>) {

    val meetingRoom = Q1_MeetingRoom()

    val interval1 = Interval(15, 20)
    val interval2 = Interval(5, 10)
    val interval3 = Interval(0, 30)

    var intervals = arrayOf(interval1, interval2, interval3)

    println(meetingRoom.solve(intervals) == false)

    intervals = arrayOf(interval2, interval1)

    println(meetingRoom.solve(intervals) == true)
}