import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] num = new int[K];
		
		int max = 0;
		for(int i = 0; i < K; i++) {
			num[i] = Integer.parseInt(in.readLine());
			max = Math.max(max, num[i]);
		}
		
		long low = 1;
		long high = max;
		long mid = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			
			long sum = 0;
			for(int i = 0; i < K; i++) {
				sum += num[i] / mid;
			}
			if(sum < N) {
				high = mid - 1;
			}
			else low = mid + 1;
		}
		System.out.println(high);
	}
}
