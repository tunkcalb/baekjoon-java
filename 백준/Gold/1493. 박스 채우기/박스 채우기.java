import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cubes = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			
			cubes[t] = f;
		}
		
		long box = 0;
		long cnt = 0;
		for(int i = N - 1; i >= 0; i--) {
			box <<= 3;
			
			long cube = (long) (L >> i) * (W >> i) * (H >> i) - box;
			long possibleCubes = Math.min((long) cubes[i], cube);
			
			box += possibleCubes;
			cnt += possibleCubes;
		}
		
		if(box == (long) L * W * H) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}
}
