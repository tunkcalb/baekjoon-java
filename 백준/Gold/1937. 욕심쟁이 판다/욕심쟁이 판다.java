import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(in.readLine());
        
        board = new int[N][N];
        dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        ans = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int r, int c) {
        
        if(dp[r][c] != 0) return dp[r][c];
        
        dp[r][c] = 1;
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if(board[r][c] >= board[nr][nc]) continue;
            
            dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
        }
        return dp[r][c];
    }
}
