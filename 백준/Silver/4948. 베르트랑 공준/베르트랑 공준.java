import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int size = 123456 * 2;
		
		boolean[] nums = new boolean[size + 1];
		
		for(int i = 2; i <= size; i++) {
			if(nums[i]) continue;
			for(int j = 2; j <= size; j++) {
				if(i * j > size) break;
				nums[i * j] = true;
			}
		}
		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n == 0) break;
			
			int sum = 0;
			for(int i = n + 1; i <= 2 * n; i++) {
				if(!nums[i]) sum++;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
