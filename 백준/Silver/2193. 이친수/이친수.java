import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		long[] num = new long[(int)N + 1];
		
		num[1] = 1;
		if(N >= 2) num[2] = 1;
		
		for(int i = 3; i <= N; i++) {
			num[i] = num[i - 1] + num[i - 2];
		}
		
		System.out.println(num[N]);
	}
}
