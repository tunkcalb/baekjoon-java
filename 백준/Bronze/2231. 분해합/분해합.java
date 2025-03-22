import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		int len = line.length();
		int N = Integer.parseInt(line);
		int ans = 0;
		
		for(int i = (N - (len * 9)); i < N; i++) {
			int num = i;
			int sum = 0;
			while(num != 0) {
				sum += num % 10;
				num /= 10;
			}
			
			if(sum + i == N) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
