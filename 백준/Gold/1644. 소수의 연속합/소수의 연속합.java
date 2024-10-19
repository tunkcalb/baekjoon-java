import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		boolean[] nums = new boolean[N + 1];
		nums[1] = true;
		for(int i = 2; i <= N; i++) {
			if(nums[i]) continue;
			for(int j = i * 2; j <= N; j += i) {
				nums[j] = true;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		int idx = 0;
		list.add(0);
		for(int i = 2; i <= N; i++) {
			if(!nums[i]) {
				list.add(list.get(idx++) + i);
			}
		}
		
		int start = list.size() - 1;
		int end = list.size() - 1;
		int cnt = 0;
		while(start > 0) {
			int diff = list.get(end) - list.get(start - 1);
			
			if(diff == N) {
				cnt++;
				start--;
				end--;
			}
			else if (diff < N) {
				start--;
			}
			else end--;
		}
		System.out.println(cnt);
	}
}
