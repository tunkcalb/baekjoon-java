import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> f = new HashSet<>();
		for(int i = 0; i < N; i++) {
			f.add(Integer.parseInt(br.readLine()));
		}
		
		int min = cal(A, B, f);
		
		System.out.println(min);
	}

	private static int cal(int a, int b, Set<Integer> f) {
		int min = Math.abs(b - a);
		
		for(int num : f) {
			int cnt = Math.abs(b - num) + 1;
			min = Math.min(min, cnt);
		}
		return min;
	}
}
