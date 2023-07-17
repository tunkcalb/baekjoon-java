import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(in.readLine());
			int[] num = new int[n + 4];
			
			num[1] = 1;
			num[2] = 1;
			num[3] = 1;
			for(int i = 1; i <= n; i++) {
				num[i + 1] += num[i];
				num[i + 2] += num[i];
				num[i + 3] += num[i];
			}
			sb.append(num[n]).append("\n");
		}
		System.out.println(sb);
	}
}
