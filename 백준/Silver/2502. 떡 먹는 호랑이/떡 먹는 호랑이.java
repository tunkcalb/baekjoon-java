import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] a = new int[D + 1];
		int[] b = new int[D + 1];
		
		a[1] = 1;
		a[3] = 1;
		b[2] = 1;
		b[3] = 1;
		
		for(int i = 4; i <= D; i++) {
			a[i] = a[i - 1] + a[i - 2];
			b[i] = b[i - 1] + b[i - 2];
		}
		
		for(int i = 1; i <= 100000; i++) {
			if((K - a[D] * i) % b[D] == 0) {
				System.out.println(i);
				System.out.println((K - a[D] * i) / b[D]);
				return;
			}
		}
	}
}
