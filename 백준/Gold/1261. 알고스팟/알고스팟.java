import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int min;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for(int j = 1; j <= M; j++) {
                board[i][j] = line.charAt(j - 1) - '0';
            }
        }

        min = N * M;

        bfs();

        System.out.println(min);
    }

    private static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);

        pq.offer(new Point(1, 1, 0));
        visited[1][1] = true;
        while(!pq.isEmpty()) {
            Point now = pq.poll();
            int r = now.r;
            int c = now.c;
            int cnt = now.cnt;

            if(r == N && c == M) {
                min = Math.min(min, cnt);
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr <= 0 || nr > N || nc <= 0 || nc > M) continue;
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                if(board[nr][nc] == 0) {
                    pq.offer(new Point(nr, nc, cnt));
                } else {
                    pq.offer(new Point(nr, nc, cnt + 1));
                }
            }
        }
    }

    static class Point {
        int r;
        int c;
        int cnt;

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
