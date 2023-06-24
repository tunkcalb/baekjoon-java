import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int period = 1500000;
		
		long size = Long.parseLong(in.readLine()) % period;
		
		int[] num = new int[period + 1];
		
		num[0] = 0;
		num[1] = 1;
		for(int i = 2; i <= period; i++) {
			num[i] = (num[i - 1] + num[i - 2]) % 1000000;
		}
		
		System.out.println(num[(int)size]);
	}
}
