
import java.util.*;

class MinimumMeetingRoomsArray{

    public int minimumMeetingRooms(int[][] meetings){

        if(meetings == null)
            return -1;
        if(meetings.length < 2)
            return meetings.length;

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (a, b) -> a[1] - b[1]
        );

        pq.offer(meetings[0]);
        for(int i = 1; i < meetings.length; i++){

            int[] curr = pq.poll();
            if(curr[1] >= meetings[i][0]){
                curr[1] = meetings[i][1];
                pq.offer(curr);
            } else{
                pq.offer(curr);
                pq.offer(meetings[i]);
            }
        }
        return pq.size();
    }
}