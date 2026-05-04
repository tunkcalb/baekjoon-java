import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        
        int h = n / w + 1;
        
        int[][] board = new int[h][w];
        int[] dc = {1, -1};
        int dir = 0;
        int r = 0;
        int c = 0;
        
        int row = 0;
        int col = 0;
        for(int i = 1; i <= n; i++) {
            board[r][c] = i;
            
            if(i == num) {
                row = r;
                col = c;
            }
            if(c + dc[dir] < 0 || c + dc[dir] >= w) {
                dir = (dir + 1) % 2;
                r++;
            }
            else {
                c = c + dc[dir];
            }
        }
        
        int cnt = 1;
        
        for(int i = row + 1; i < h; i++) {
            if(board[i][col] != 0) cnt++;
        }
        return cnt;
    }
}