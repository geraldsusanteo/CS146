import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // Sort intervals based on start times
        
        if (!validIntervals(intervals)) {
            System.out.println("Interval Time is invalid");
        } else {
            System.out.println(minMeetingRooms(intervals));
        }
    }

    public static int minMeetingRooms(int[][] intervals) {
        int totalServers = 0;
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
    
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
    
            while (!endTimes.isEmpty() && endTimes.peek() <= start) {
                endTimes.poll();
            }
            endTimes.add(end);
    
            totalServers = Math.max(totalServers, endTimes.size());
        }
        return totalServers;
    }
    
    public static boolean validIntervals(int[][] intervals) {
        if (intervals.length <= 1 || intervals.length >= 1000000) {
            return false;
        }
        return intervals[0][0] >= 0 && intervals[intervals.length - 1][1] <= 100000;
    }
} 
