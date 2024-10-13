import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringTokenizer st = null;
		for(int t = 0; t < T; t++) {
			in.readLine();
			
			st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			
			int S = 0;
			int B = 0;
			for(int i = 0; i < N; i++) {
				S = Math.max(S, Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < M; j++) {
				B = Math.max(B, Integer.parseInt(st.nextToken()));
			}
			if(S < B) System.out.println("B");
			else System.out.println("S");
		}
	}
}
