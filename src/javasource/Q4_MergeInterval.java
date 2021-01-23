package javasource;

import java.util.*;
import java.util.stream.Collectors;

public class Q4_MergeInterval {
    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);

        Interval interval5 = new Interval(7, 9);
        Interval interval3 = new Interval(8, 10);

        Interval interval6 = new Interval(10, 11);

        Interval interval4 = new Interval(15, 18);
        Interval interval7 = new Interval(17, 20);
        Interval interval8 = new Interval(18, 20);

        List<Interval> intervals = Arrays.asList(interval1, interval2, interval3, interval4, interval5, interval6, interval7, interval8);

        Q4_MergeInterval a = new Q4_MergeInterval();
        List<Interval> list = a.merge2(intervals);

        System.out.println(list.toString());
    }

    private List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;

        intervals.sort((a, b) -> a.start - b.start);
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            int index = result.size() - 1;
            if (result.get(index).end >= intervals.get(i).start) {
                result.set(index, new Interval(result.get(index).start, intervals.get(i).end));
                i++;
            } else {
                result.add(intervals.get(i));
            }
        }
        return result;
    }

    private List<Interval> merge2(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;

        intervals.sort((a, b) -> a.start - b.start);
        List<Interval> result = new ArrayList<>();
        Interval before = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (before.end >= current.start) {
                before.end = current.end;
            } else {
                result.add(before);
                before = current;
            }
        }

        if(!result.contains(before)) {
            result.add(before);
        }

        return result;
    }
}
