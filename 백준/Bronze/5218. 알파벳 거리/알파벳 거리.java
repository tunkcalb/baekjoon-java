import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			int len = str1.length();
			
			int[] nums = new int[len];
			
			for(int j = 0; j < len; j++) {
				nums[j] = str2.charAt(j) - str1.charAt(j);
				
				if(nums[j] < 0) nums[j] += 26;
			}
			
			sb.append("Distances: ");
			
			for(int j = 0; j < len; j++) {
				sb.append(nums[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
