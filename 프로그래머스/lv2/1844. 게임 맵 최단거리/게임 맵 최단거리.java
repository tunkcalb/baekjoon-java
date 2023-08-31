import java.util.*;
import java.io.*;

class Solution {
    
    public boolean[][] visited;
    public int[] dr = {0, 0, -1, 1};
    public int[] dc = {-1, 1, 0, 0};
    public int h, w;
    public int answer = -1;
    public int solution(int[][] maps) {
        h = maps.length;
        w = maps[0].length;
        visited = new boolean[h][w];
        bfs(maps);
        
        return answer;
    }
    public void bfs(int[][] maps){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Point now = q.poll();
            int r = now.r;
            int c = now.c;
            int cnt =  now.cnt;
            if(r == h - 1 && c == w - 1) {
                answer = cnt;
                return;
            }
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= h || nc < 0 || nc >= w || visited[nr][nc] || maps[nr][nc] == 0) continue;
                q.offer(new Point(nr, nc, cnt + 1));
                visited[nr][nc] = true;
            }
        }
    }
    public class Point{
        int r;
        int c;
        int cnt;
        
        Point(int r , int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}