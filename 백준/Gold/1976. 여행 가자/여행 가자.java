import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		int[][] roads = new int[N + 1][N + 1];
		
		parents = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 1; j <= N; j++) {
				roads[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = i + 1; j <= N; j++) {
				if(roads[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			find(i);
		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int num = parents[Integer.parseInt(st.nextToken())];
		boolean canGo = true;
		for(int i = 1; i < M; i++) {
			int nextNum = parents[Integer.parseInt(st.nextToken())];
			if(num != nextNum) canGo = false;
		}
		
		if(canGo) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void union(int i, int j) {
		int a = find(i);
		int b = find(j);
		
		parents[b] = a;
	}
	
	private static int find(int i) {
		if(parents[i] != i) {
			parents[i] = find(parents[i]);
		}
		return parents[i];
	}
}
