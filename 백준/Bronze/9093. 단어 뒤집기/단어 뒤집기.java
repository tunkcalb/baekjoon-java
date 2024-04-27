import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String[] words = in.readLine().split(" ");
			
			for(String word : words) {
				StringBuilder string = new StringBuilder(word);
				sb.append(string.reverse().toString()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
