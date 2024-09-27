import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;
        for(int i = 1; i <= N; i++) {
            int v = Integer.parseInt(st.nextToken());
            for(int j = 0; j <= M; j++) {
                if(dp[i - 1][j]) {
                    if(j - v >= 0) dp[i][j - v] = true;
                    if(j + v <= M) dp[i][j + v] = true;
                }
            }
        }
        int max = -1;
        for(int i = M; i >= 0; i--) {
            if(dp[N][i]) {
                max = i;
                break;
            }
        }

        System.out.println(max);
    }
}
