import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] spicey = new int[N];
		int[] sweet = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			spicey[i] = Integer.parseInt(st.nextToken());
			sweet[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(spicey[j] >= u && spicey[j] <= v && sweet[j] >= x && sweet[j] <= y) cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
