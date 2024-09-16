import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] r = new int[M];
		int[] c = new int[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(r);
		Arrays.sort(c);
		
		int midR = r[M/2];
		int midC = c[M/2];
		int sum = 0;
		for(int i = 0; i < M; i++) {
			sum += Math.abs(r[i] - midR);
			sum += Math.abs(c[i] - midC);
		}
		System.out.println(sum);
	}
}
