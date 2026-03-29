import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			sum += (Integer.parseInt(st.nextToken()) + 1) / 2;
		}
		
		if(N <= sum) System.out.println("YES");
		else System.out.println("NO");
	}
}
