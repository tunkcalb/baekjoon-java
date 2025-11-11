import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int INF = Integer.MAX_VALUE;
		int min = INF;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a > b) continue;
			min = Math.min(min, b);
		}
		
		if(min == INF) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
}
