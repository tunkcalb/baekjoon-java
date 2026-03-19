import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final long INF = 999999999999L;
    static int n;
    static int[] notes;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null) return;
        n = Integer.parseInt(line.trim());

        notes = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            notes[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[n + 4][n + 4];
        for (int i = 0; i <= n + 3; i++) {
            for (int j = 0; j <= n + 3; j++) {
                dp[i][j] = -INF;
            }
        }

        dp[1][1] = notes[1];
        dp[1][0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == -INF) continue;

                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + (long)notes[i + 1] * (j + 1));

                if (i + 2 > n) {
                    dp[n][0] = Math.max(dp[n][0], dp[i][j]);
                } else {
                    dp[i + 2][1] = Math.max(dp[i + 2][1], dp[i][j] + notes[i + 2]);
                }

                if (i + 3 > n) {
                    dp[n][0] = Math.max(dp[n][0], dp[i][j]);
                } else {
                    if (i == 1 && j == 0) continue;
                    dp[i + 3][1] = Math.max(dp[i + 3][1], dp[i][j] + notes[i + 3]);
                }
            }
        }

        long answer = 0;
        for (int i = 0; i <= n; i++) {
            answer = Math.max(answer, dp[n][i]);
        }

        System.out.println(answer);
    }
}
