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
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(num[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
