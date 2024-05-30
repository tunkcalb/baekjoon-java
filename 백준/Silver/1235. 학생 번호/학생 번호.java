import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String[] nums = new String[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = in.readLine();
		}
		
		int ans = 1;
		int len = nums[0].length();
		while(true) {
			HashSet<String> set = new HashSet<>();
			
			for(int i = 0; i < N; i++) {
				set.add(nums[i].substring(len - ans, len));
			}
			if(set.size() == N) break;
			ans++;
		}
		System.out.println(ans);
	}
}
