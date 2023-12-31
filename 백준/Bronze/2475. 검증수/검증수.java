import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = 5;
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num * num;
		}
		System.out.println(sum % 10);
	}
}
