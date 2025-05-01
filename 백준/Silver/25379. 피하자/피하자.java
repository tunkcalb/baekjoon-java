import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long lCnt = 0;
		long rCnt = 0;
		long sum = 0;
		int idx = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num % 2 == 0) {
				sum += idx++;
				lCnt += i;
				rCnt += N - 1 - i;
			}
		}
		
		System.out.println(Math.min(lCnt, rCnt) - sum);
	}
}
