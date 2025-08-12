import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		A %= B;
		
		for(int i = 1; i <= N; i++) {
			A *= 10;
			if(i == N) break;
			A %= B;
		}
		
		System.out.println(A / B);
	}
}
