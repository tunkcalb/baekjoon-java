import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
    static int[][][] board = new int[5][5][5];
    static int[][][] maze = new int[5][5][5];
    static boolean[] used = new boolean[5];
    static int[][][] rotatedBoard = new int[4][5][5];
    static int[] dr = {0, 0, 0, 0, -1, 1};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {-1, 1, 0, 0, 0, 0};
    static int min = Integer.MAX_VALUE;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        for (int h = 0; h < N; h++) {
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[h][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        permuteLayers(0, new int[N]);
        System.out.println(min == INF ? -1 : min);
    }

    static void permuteLayers(int depth, int[] order) {
        if (depth == N) {
            rotateLayers(order, 0, new int[N]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                order[depth] = i;
                permuteLayers(depth + 1, order);
                used[i] = false;
            }
        }
    }

    static void rotateLayers(int[] order, int depth, int[] rotation) {
        if (depth == N) {
            buildMaze(order, rotation);
            if (maze[0][0][0] == 1 && maze[N - 1][N - 1][N - 1] == 1) {
                bfs();
            }
            return;
        }

        for (int r = 0; r < 4; r++) {
            rotation[depth] = r;
            rotateLayers(order, depth + 1, rotation);
        }
    }

    static void buildMaze(int[] order, int[] rotation) {
        for (int l = 0; l < N; l++) {
            int[][] rot = rotate(board[order[l]], rotation[l]);
            for (int i = 0; i < N; i++) {
                System.arraycopy(rot[i], 0, maze[l][i], 0, N);
            }
        }
    }

    static int[][] rotate(int[][] map, int count) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, result[i], 0, N);
        }

        for (int r = 0; r < count; r++) {
            int[][] temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[j][N - 1 - i] = result[i][j];
                }
            }
            result = temp;
        }
        return result;
    }

    static void bfs() {
        boolean[][][] visited = new boolean[N][N][N];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
        	Point now = q.poll();
            if (now.h == N - 1 && now.r == N - 1 && now.c == N - 1) {
                min = Math.min(min, now.cnt);
                return;
            }

            for (int d = 0; d < 6; d++) {
                int nh = now.h + dh[d];
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nh < 0 || nr < 0 || nc < 0 || nh >= N || nr >= N || nc >= N) continue;
                if (maze[nh][nr][nc] == 0 || visited[nh][nr][nc]) continue;

                visited[nh][nr][nc] = true;
                q.offer(new Point(nh, nr, nc, now.cnt + 1));
            }
        }
    }

    static class Point {
        int r, c, h, cnt;

        Point(int h, int r, int c, int cnt) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
