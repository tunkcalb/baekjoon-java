import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int len = line.length();

        int[][] board = new int[len][26];

        board[0][line.charAt(0) - 'a'] = 1;

        for (int i = 1; i < len; i++) {
            for (int c = 0; c < 26; c++) {
            	board[i][c] = board[i - 1][c];
            }
            board[i][line.charAt(i) - 'a']++;
        }

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char target = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int idx = target - 'a';
            int cnt;

            if (start == 0) {
            	cnt = board[end][idx];
            } else {
            	cnt = board[end][idx] - board[start - 1][idx];
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
