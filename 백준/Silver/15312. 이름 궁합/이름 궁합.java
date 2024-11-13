import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String A = in.readLine();
		String B = in.readLine();
		int len = A.length() + B.length();
		List<Integer> list = new ArrayList<>();
		
		int[] cnt = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		
		for(int i = 0; i < A.length(); i++) {
			list.add(cnt[A.charAt(i) - 'A']);
			list.add(cnt[B.charAt(i) - 'A']);
		}
		
		while(list.size() > 2) {
			int size = list.size();
			List<Integer> nums = new ArrayList<>();
			for(int i = 0; i < size - 1; i++) {
				int num = list.get(i) + list.get(i + 1);
				num %= 10;
				nums.add(num);
			}
			list = nums;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0)).append(list.get(1));
		System.out.println(sb);
	}
}
