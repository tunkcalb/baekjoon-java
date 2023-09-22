import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		List<Integer> nums = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(in.readLine()));
		}
		
		nums.sort(Comparator.reverseOrder());
		
		
		StringBuilder sb = new StringBuilder();
		
		for(Integer num : nums) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}
}
