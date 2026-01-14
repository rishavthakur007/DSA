package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CountPaths {
	
	public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]});
        }

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        long[] time = new long[n];
        int[] count = new int[n];

        Arrays.fill(time, Long.MAX_VALUE);

        time[0] = 0;
        count[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long t = cur[0];
            int node = (int) cur[1];

            if (t > time[node]) continue;

            for (int[] e : adj.get(node)) {
                int next = e[0];
                long newTime = t + e[1];

                if (newTime == time[next]) {
                    count[next] = (count[next] + count[node]) % mod;
                }
                else if (newTime < time[next]) {
                    time[next] = newTime;
                    count[next] = count[node];
                    pq.offer(new long[]{newTime, next});
                }
            }
        }

        return count[n - 1];
    }

}
