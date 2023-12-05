import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] nums = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<>();
		
		list.add(Integer.MIN_VALUE);
		
		for(int i = 1; i <= N; i++) {
			int num = nums[i];
			int left = 1;
			int right = list.size() - 1;
			if(num > list.get(list.size() - 1)) list.add(num);
			else  {
				while(left < right) { 
					int mid = (left + right) / 2;
					if(list.get(mid) >= num) right = mid;
					else left = mid + 1;
				}
				list.set(right, num);
			}
		}
		System.out.println(list.size() - 1);
	}
}
