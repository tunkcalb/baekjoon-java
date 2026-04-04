import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int cnt = m;
		int max = m;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int in = Integer.parseInt(st.nextToken());
			int out = Integer.parseInt(st.nextToken());
			
			cnt += in;
			cnt -= out;
			
			if(cnt < 0) {
				max = 0;
				break;
			}
			
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}
}
