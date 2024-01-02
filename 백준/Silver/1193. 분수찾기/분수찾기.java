import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(in.readLine());
		
		int idx = 0;
		
		int num = 0;
		
		while(num < X) {
			idx++;
			num += idx;
		}
		
		if(idx % 2 == 0) {
			System.out.println((idx - num + X) + "/" + (num - X + 1));
		}else {
			System.out.println((num - X + 1) + "/" + (idx - num + X));
		}
	}
}
