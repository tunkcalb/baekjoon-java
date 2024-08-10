import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		
		List<Integer> list = new ArrayList<>();
		
		list.add(Integer.MIN_VALUE);
		
		int[] index = new int[N];
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums[i] = num;
			if(list.get(list.size() - 1) < num) {
				list.add(num);
				index[i] = list.size() - 1;
			}
			else {
				int start = 0;
				int end = list.size() - 1;
				
				while(start < end) {
					int mid = (start + end) / 2;
					
					if(list.get(mid) < num) start = mid + 1;
					else end = mid;
				}
				list.set(end, num);
				index[i] = end;
			}
		}

		Stack<Integer> stack = new Stack<>();
		int idx = list.size() - 1;
		for(int i = N - 1; i >= 0; i--) {
			if(index[i] == idx) {
				stack.push(nums[i]);
				idx--;
			}
		}
		StringBuilder sb = new StringBuilder();
		int size = stack.size();
		sb.append(size).append("\n");
		
		for(int i = 0; i < size; i++) {
			sb.append(stack.pop());
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
