package javasource;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q5_MeetingRoom2 {

    public static void main(String[] args) {
        Q5_MeetingRoom2 a = new Q5_MeetingRoom2();

        // false 예제
        Interval intervals3 = new Interval(0, 30);
        Interval intervals2 = new Interval(5, 10);
        Interval intervals1 = new Interval(15, 20);

/*
        // true 예제
        Interval intervals1 = new Interval(2, 4);
        Interval intervals2 = new Interval(7, 10);
*/
        Interval[] intervals = {intervals1, intervals2, intervals3};
        System.out.println(a.solve(intervals));
    }

    private int solve(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        Queue<Interval> minHeap = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            while(!minHeap.isEmpty() && minHeap.peek().end >= intervals[i].start) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i]);
            max = Math.max(max, minHeap.size());
        }
        return max;
    }

}
