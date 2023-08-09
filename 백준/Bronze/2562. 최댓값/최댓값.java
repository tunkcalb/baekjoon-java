import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int idx = 0;
		for(int i = 1; i <= 9; i++) {
			int num = Integer.parseInt(in.readLine());
			
			if(max < num) {
				max = num;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}
