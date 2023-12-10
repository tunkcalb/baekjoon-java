import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N];
		int[] prefixSum = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int sum =  0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum  += arr[i];
			prefixSum[i + 1] = sum;
		}
		
		long ans = 0;
		for(int i = 0; i < N; i++) {
			int num = arr[i];
			int calSum = prefixSum[N] - prefixSum[i + 1];
			ans += num * calSum;
		}
		System.out.println(ans);
		
	}
}
