import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = 7;
		
		int[] answer = new int[100001];
		
		for(int i = 0; i < N; i++) {
			answer[(int) (Double.parseDouble(in.readLine()) * 1000.0)]++;
		}
		
		int cnt = 0;
		for(int i = 0; i < answer.length; i++) {
			while(answer[i] > 0 && cnt < 7) {
				System.out.printf("%.3f\n", i / 1000.0);
				answer[i]--;
				cnt++;
			}
		}
	}
}
