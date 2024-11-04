import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N != 0) st = new StringTokenizer(in.readLine());
		int sum = M;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int w = Integer.parseInt(st.nextToken());
			if(sum + w > M) {
				sum = 0;
				cnt++;
			}
			sum += w;
		}
		System.out.println(cnt);
	}
}
