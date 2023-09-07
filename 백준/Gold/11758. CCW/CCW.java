import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		double[][] nums = new double[3][2];
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			nums[i][0] = Double.parseDouble(st.nextToken());
			nums[i][1] = Double.parseDouble(st.nextToken());
		}
		
		double a1 = nums[0][0] * nums[1][1] + nums[1][0] * nums[2][1] + nums[2][0] * nums[0][1];
		double a2 = nums[0][1] * nums[1][0] + nums[1][1] * nums[2][0] + nums[2][1] * nums[0][0];
		
		int ans = 0;
		if (a1 > a2) ans = 1;
		else if (a1 < a2) ans = -1;
		System.out.println(ans);
	}
}
