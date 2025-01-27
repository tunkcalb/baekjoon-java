import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int num : nums) {
			int pos = Collections.binarySearch(list, num);
			
			if(pos < 0) pos = -(pos + 1);
			
			if(pos == list.size()) {
				list.add(num);
			}
			else {
				list.set(pos, num);
			}
		}
		
		System.out.println(N - list.size());
	}
}
