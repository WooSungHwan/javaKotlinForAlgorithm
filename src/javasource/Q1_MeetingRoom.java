package javasource;

import java.util.Arrays;

public class Q1_MeetingRoom {

    public static void main(String[] args) {
        Q1_MeetingRoom a = new Q1_MeetingRoom();

        // false 예제
        Interval intervals1 = new Interval(15, 20);
        Interval intervals2 = new Interval(5, 10);
        Interval intervals3 = new Interval(0, 30);

/*
        // true 예제
        Interval intervals1 = new Interval(2, 4);
        Interval intervals2 = new Interval(7, 10);
*/
        Interval[] intervals = {intervals1, intervals2, intervals3};
        System.out.println(a.solve(intervals));
    }

    public boolean solve(Interval[] intervals) {
        if (intervals == null) return false;
        Arrays.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

    public void print(Interval[] intervals) {
        for (Interval interval : intervals) {
            System.out.println(interval.toString());
        }
    }

}

class Interval {
    public int start;
    public int end;

    Interval() {
        this.start = 0;
        this.end = 0;
    }

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("start = %s, end = %s", start, end);
    }
}
