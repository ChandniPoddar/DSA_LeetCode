import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap for available rooms
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        // Min-heap for busy rooms: [endTime, roomNumber]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] == b[0]
                        ? Long.compare(a[1], b[1])
                        : Long.compare(a[0], b[0])
        );

        int[] roomCount = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free rooms that have finished before current meeting
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                // Assign available room
                int room = availableRooms.poll();
                busyRooms.offer(new long[]{end, room});
                roomCount[room]++;
            } else {
                // Delay meeting
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                busyRooms.offer(new long[]{newEnd, earliest[1]});
                roomCount[(int) earliest[1]]++;
            }
        }

        // Find room with maximum meetings
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (roomCount[i] > roomCount[result]) {
                result = i;
            }
        }

        return result;
    }
}
