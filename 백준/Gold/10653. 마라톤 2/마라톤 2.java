import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int x, y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }        
    }
    
    static int N, K;
    static Point[] checkPoint;
    static int[][] distance;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        checkPoint = new Point[N + 1];
        
        dp = new int[N + 1][K + 1];
        distance = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checkPoint[i] = new Point(x, y);
            Arrays.fill(dp[i], -1);
        }
        
        for(int i = 1; i < N; i++) {
        	for(int j = i + 1; j <= N; j++) {
        		distance[i][j] = getDistance(checkPoint[i].x, checkPoint[i].y, checkPoint[j].x, checkPoint[j].y);
        	}
        }
        
        System.out.println(dfs(N, K));
        
    }

	private static int dfs(int n, int k) {
		if(dp[n][k] != -1) return dp[n][k];
		if(n == 1) return 0;
		
		int ans = Integer.MAX_VALUE;
		for(int i  = 0; i <= k; i++) {
			if( 1 <= n - 1 - i) {
				ans = Math.min(ans, dfs(n - i - 1, k - i) + distance[n - i - 1][n]);
			}
		}
		dp[n][k] = ans;
		return ans;
	}

	private static int getDistance(int x, int y, int x2, int y2) {
		return Math.abs(x - x2) + Math.abs(y - y2);
	}
}
