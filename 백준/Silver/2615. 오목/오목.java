import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = 19;
        int[][] board = new int[N][N];
        int[] dr = {0, 1, 1, -1};
        int[] dc = {1, 0, 1, 1};
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0) continue;
                
                int player = board[i][j];

                for(int k = 0; k < 4; k++) {
                    
                    int pr = i - dr[k];
                    int pc = j - dc[k];
                    if(pr >= 0 && pc >= 0 && pr < N && pc < N && board[pr][pc] == player) continue;
                    
                    int cnt = 1;
                    int nr = i;
                    int nc = j;
                    
                    while(true) {
                        nr += dr[k];
                        nc += dc[k];
                        
                        if(nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] != player) break;
                        
                        cnt++;
                        
                        if(cnt == 5) {
                            int nx = nr + dr[k];
                            int ny = nc + dc[k];
                            
                            if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] != player) {
                                System.out.println(player);
                                System.out.println((i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }

                }
            }
        }
        System.out.println(0);
    }
}
