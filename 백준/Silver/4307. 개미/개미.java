import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			boolean[] ants = new boolean[l + 1];
			
			for(int i = 0; i < n; i++) {
				ants[Integer.parseInt(br.readLine())] = true;
			}
			
			int left = l / 2;
			int right= l / 2;
			
			while(left > 0) {
				if(ants[left]) break;
				left--;
			}
			while(right < l) {
				if(ants[right]) break;
				right++;
			}
			
			sb.append(Math.max(left,  l - right)).append(" ");
			left = 0;
			right = l;
			
			while(left < l) {
				if(ants[left]) break;
				left++;
			}
			
			while(right > 0) {
				if(ants[right]) break;
				right--;
			}
			
			sb.append(Math.max(l - left,  right)).append("\n");
		}
		
		System.out.println(sb);
	}
}
