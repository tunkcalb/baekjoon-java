import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        int r = 0;
        int c = 0;
        int dir = 0;
        go : while(true) {
        	visited[r][c] = true;
        	for(int i = 0; i < 4; i++) {
        		int nr = r + dr[(dir + i) % 4];
        		int nc = c + dc[(dir + i) % 4];
        		
        		if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
        		if(visited[nr][nc]) continue;
        		
        		r = nr;
        		c = nc;
        		dir += i;
        		dir %= 4;
        		continue go;
        	}
        	break;
        }
        System.out.println(r + " " + c);
    }
}
