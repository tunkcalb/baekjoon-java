import java.io.*;
import java.util.*;

public class Main {
    static int N = 10;
    static int min;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int INF = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = INF;
        dfs(0);
        System.out.println(min == INF ? -1 : min);
    }

    private static void dfs(int cnt) {
        if (cnt >= min) return;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    for (int k = 5; k >= 1; k--) {
                        if (check(i, j, k) && paper[k] > 0) {
                            paper[k]--;
                            fill(i, j, k);
                            dfs(cnt + 1);
                            paper[k]++;
                            empty(i, j, k);
                        }
                    }
                    return;
                }
            }
        }
        min = Math.min(min, cnt);
    }

    private static boolean check(int r, int c, int n) {
        if (r + n > N || c + n > N) return false;
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (board[i][j] != 1 || visited[i][j]) return false;
            }
        }
        return true;
    }

    private static void fill(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                visited[i][j] = true;
            }
        }
    }

    private static void empty(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                visited[i][j] = false;
            }
        }
    }
}
