import java.io.*;
import java.util.*;

public class Main {
	
	static String[] alpha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "tem"};
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int size = N - M + 1;
		
		String[][] nums = new String[size][2];
		
		for(int i = M; i <= N; i++) {
			nums[i - M][0] = String.valueOf(i);
			String num = nums[i - M][0];
			for(int j = 0; j < num.length(); j++) {
				nums[i - M][1] += alpha[num.charAt(j) - '0'];
			}
		}
		
		Arrays.sort(nums, (o1, o2) -> {
			return o1[1].compareTo(o2[1]);
		});
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(String[] num : nums) {
			cnt++;
			sb.append(num[0]).append(" ");
			if(cnt == 10) {
				sb.append("\n");
				cnt = 0;
			}
		}
		System.out.println(sb);
	}
}
