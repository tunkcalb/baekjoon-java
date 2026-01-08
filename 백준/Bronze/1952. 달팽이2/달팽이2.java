import java.util.*;
import java.io.*;

public class Main {
    
	static int N, M;
	static int[][] map;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	
    	M = sc.nextInt();
    	N = sc.nextInt();
    	sc.close();
    	
    	map = new int[M][N];
    	visited = new boolean[M][N];
    	
    	int cnt = 0;
    	int sum = 0;
    	
    	int idx = 0;
    	int r = 0;
    	int c = 0;
    	visited[r][c] = true;
    	sum = 1;
    	
    	while(idx < 4) {
    		int nr = r + dr[idx];
    		int nc = c + dc[idx];
    		
    		if(sum == N*M) {
    			System.out.println(cnt);
    			return;
    		}
    		
    		if(nr >= 0 && nc >= 0 && nr < M && nc < N && !visited[nr][nc]) {
    			sum++;
    			visited[nr][nc] = true;
    			r = nr;
    			c = nc;
    		} 

    		else {
    			idx++;
    			cnt++;
    		}
    		
    		if(idx >= 4) {
    			idx = 0;
    		}
    	}
    	
    }
	
}
