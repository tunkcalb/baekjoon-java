import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String[] line = in.readLine().split(" ");

		
		float max = 0;
		float sum = 0;
		
		float[] nums = new float[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Float.parseFloat(line[i]);
			sum += nums[i];
			
			if(max < nums[i]) max = nums[i];
		}
		
		sum -= max;
		sum /= 2;
		
		sum += max;
		if(sum == (int) sum) {
			System.out.println((int) sum);			
		}
		else {
			System.out.println(sum);
		}
	}
}