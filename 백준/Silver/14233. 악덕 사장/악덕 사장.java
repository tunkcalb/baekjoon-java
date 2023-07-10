import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] num = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		for(int i = 1; i <= n; i++) {
			num[i] /= i;
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++) {
			ans = Math.min(ans, num[i]);
		}
		System.out.println(ans);
	}
}
