import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			
			int sum = cal(line);
			
			sb.append(sum).append("\n");
			
		}
		System.out.println(sb);
	}

	private static int cal(String line) {
		int sum = 0;
		int plus = 1;
	
		for(int i = 0; i < line.length(); i++) {
			
			if(line.charAt(i) == 'O' ) {
				sum += plus;
				plus++; 
			}
			else plus = 1;
		}
		
		return sum;
	}
}
