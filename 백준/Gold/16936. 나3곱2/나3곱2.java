import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static long[][] nums;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		nums = new long[N][2];
		for (int i = 0; i < N; i++) {
			nums[i][0] = Long.parseLong(st.nextToken());
			long num = nums[i][0];
			while(num % 3 == 0) {
				num /= 3;
				nums[i][1]++;
			}
		}
		Arrays.sort(nums, new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[1] == o2[1]) return Long.compare(o1[0], o2[0]);
				return Long.compare(o2[1], o1[1]);
			}
		});
		
		for(int i = 0; i < N; i++) {
			sb.append(nums[i][0]).append(" ");
		}
		System.out.println(sb);
	}
}
