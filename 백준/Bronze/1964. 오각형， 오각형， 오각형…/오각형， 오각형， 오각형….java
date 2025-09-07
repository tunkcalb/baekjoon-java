import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 5;
		
		int N = Integer.parseInt(br.readLine());
		int M = 45678;
		
		for(int i = 2; i <= N; i++) {
			ans = (ans + (i * 3) + 1) % M;
		}
		
		System.out.println(ans);
	}
}
