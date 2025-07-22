import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] cups;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 3;
		int M = Integer.parseInt(br.readLine());
		
		cups = new boolean[N + 1];
		cups[1] = true;
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			swap(X, Y);
		}
		
		for(int i = 1; i <= N; i++) {
			if(cups[i]) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void swap(int x, int y) {
		
		boolean tmp = cups[x];
		cups[x] = cups[y];
		cups[y] = tmp;
	}
}
