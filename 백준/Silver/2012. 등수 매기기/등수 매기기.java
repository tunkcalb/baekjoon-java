import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] num = new int[N];
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		long sum = 0;
		
		Arrays.sort(num);
		
		for(int i = 0; i < N; i++) {
			sum += Math.abs(num[i] - i - 1);
		}
		System.out.println(sum);
	}
}
