import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(in.readLine());

			String[] nums = new String[N];

			for (int i = 0; i < N; i++) {
				nums[i] = in.readLine();
			}

			Arrays.sort(nums);
			
			boolean isConsistant = true;
			
			for(int i = 0; i < N - 1; i++) {
				if(nums[i + 1].startsWith(nums[i])) {
					isConsistant = false;
				}
			}
			
			if(isConsistant) System.out.println("YES");
			else System.out.println("NO");
		}

	}
}