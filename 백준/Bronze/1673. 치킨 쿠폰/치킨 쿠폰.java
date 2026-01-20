import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int sum = n;
			while(n >= k) {
				sum += n / k;
				n = n / k + n % k;
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
