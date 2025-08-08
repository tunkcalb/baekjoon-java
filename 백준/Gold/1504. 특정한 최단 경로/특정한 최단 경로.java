import java.io.*;
import java.util.*;

public class Main {

    static int N, E;
    static int[][] board;
    static int INF = 987654321;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(board[i], INF);
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost =  Integer.parseInt(st.nextToken());
            board[a][b] = Math.min(board[a][b], cost);
            board[b][a] = board[a][b];
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0;
        int first = dist(1, v1);
        int second = dist(v1, v2);
        int third = dist(v2, N);

        if(first == INF || second == INF || third == INF) ans1 = INF;
        else ans1 = first + second + third;

        int ans2 = 0;
        first = dist(1, v2);
        third = dist(v1, N);

        if(first == INF || third == INF) ans2 = INF;
        else ans2 = first + second + third;

        if ( ans1 == ans2 && ans1 == INF ) {
            System.out.println(-1);
        }
        else System.out.println(Math.min(ans1, ans2));
    }

    private static int dist(int start, int end) {
        int[] cost = new int[N + 1];
        Arrays.fill(cost, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{0, start});
        cost[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int nowCost = cur[0];
            int now = cur[1];

            if (nowCost > cost[now]) continue;

            for (int next = 1; next <= N; next++) {
                if (board[now][next] < INF) {
                    int nextCost = nowCost + board[now][next];
                    if (nextCost < cost[next]) {
                        cost[next] = nextCost;
                        pq.offer(new int[]{nextCost, next});
                    }
                }
            }
        }

        return cost[end];
    }
}
