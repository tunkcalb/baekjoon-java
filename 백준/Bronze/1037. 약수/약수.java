import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		System.out.println(min * max);
	}
}
