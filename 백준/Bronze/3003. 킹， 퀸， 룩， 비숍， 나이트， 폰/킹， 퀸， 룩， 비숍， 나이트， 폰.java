import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nums = {1, 1, 2, 2, 2, 8};
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int num : nums) {
			sb.append(num - Integer.parseInt(st.nextToken()));
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
