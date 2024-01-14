import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] nums;
	static int[] comb;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			nums = new int[N];
			comb = new int[6];
			
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void combination(int idx, int j) {
		if(idx == 6) {
			addcomb();
			return;
		}
		
		for(int i = j; i < N; i++) {
			comb[idx] = nums[i];
			combination(idx + 1, i + 1);
		}
		
	}

	private static void addcomb() {
		for(int i = 0; i < 6; i++) {
			sb.append(comb[i]).append(" ");
		}
		sb.append("\n");
	}
}
