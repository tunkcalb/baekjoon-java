import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (!st.hasMoreTokens()) return;
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[][][] dp = new boolean[501][501][11];
        
        dp[0][0][0] = true;

        for (int t = 0; t < 500; t++) {
            for (int s = 0; s < N; s++) {
                for (int d = 0; d <= 10; d++) {
                    if (!dp[t][s][d]) continue;

                    check(t, s + A, d, N, A, dp);
                    
                    check(t, s + B, d, N, A, dp);
                    
                    if (d + 1 <= 10 && 10 * (d + 1) <= t + 1) {
                        check(t, s * 2, d + 1, N, A, dp);
                    }
                }
            }
        }
    }

    private static void check(int t, int nextS, int nextD, int N, int A, boolean[][][] dp) {

    	if (nextS >= N) {
            if (nextS < N + A) {
                System.out.println(t + 1);
                System.exit(0);
            }
            return;
        }

        if (nextS >= 0) {
            dp[t + 1][nextS][nextD] = true;
        }
    }
}
