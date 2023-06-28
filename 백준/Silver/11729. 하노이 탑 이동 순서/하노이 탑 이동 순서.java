import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		sb.append((int) (Math.pow(2, N) - 1)).append("\n");
		Hanoi(N, 1, 2, 3);
		
		System.out.println(sb);
	}

	private static void Hanoi(int n, int start, int mid, int to) {
		
		if (n == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		
		
		Hanoi(n - 1, start, to, mid);
		
		sb.append(start + " " + to + "\n");
		
		Hanoi(n - 1, mid, start, to);
		
	}
}
