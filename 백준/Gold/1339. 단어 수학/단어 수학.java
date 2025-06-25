import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N = 26;
		Integer[] cnts = new Integer[N];
		
		Arrays.fill(cnts, 0);
		for(int t = 0; t < T; t++) {
			String line = br.readLine();
			int len = line.length();
			
			for(int i = len - 1; i >= 0; i--) {
				char now = line.charAt(i);
				cnts[now - 'A'] += (int) Math.pow(10, len - 1 - i);
			}
		}
		
		Arrays.sort(cnts, Collections.reverseOrder());
		
		int num = 9;
		
		int sum = 0;
		for(int cnt : cnts) {
			sum += cnt * num;
			num--;
		}
		
		System.out.println(sum);
	}
}
