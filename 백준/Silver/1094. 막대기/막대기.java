import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		int X = Integer.parseInt(in.readLine());
		
		int stick = 64;
		int sum = 0;
		int cnt = 0;
		
		while(true) {
			if (X == stick) {
				cnt++;
				break;
			}
			
			stick /= 2;
			if (sum + stick <= X) {
				sum += stick;
				cnt++;
				if(sum == X) {
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
