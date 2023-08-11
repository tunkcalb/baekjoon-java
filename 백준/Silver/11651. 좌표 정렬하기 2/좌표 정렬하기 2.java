import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Integer[][] nums = new Integer[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums, (o1, o2) -> {
			if(o1[1].equals(o2[1])) {
				return Integer.compare(o1[0],  o2[0]);
			}else {
				return Integer.compare(o1[1],  o2[1]);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(nums[i][0]).append(" ");
			sb.append(nums[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}
