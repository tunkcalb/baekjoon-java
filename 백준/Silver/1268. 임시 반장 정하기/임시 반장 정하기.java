import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = 5; // 학년 수
        int N = Integer.parseInt(br.readLine()); // 학생 수

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] score = new int[N];

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (i != k && board[i][j] == board[k][j]) {
                        visited[k] = true;
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                if (visited[k]) score[i]++;
            }
        }

        int max = -1;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (score[i] > max) {
                max = score[i];
                idx = i + 1;
            }
        }

        System.out.println(idx);
    }
}
