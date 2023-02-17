import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	private static int N;

	public static void main(String[] args) throws Exception {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		if(N % 5 == 0) sb.append(N/5);
		
		else {
			for(int i = 1; i <= N / 3; i++) {
				if((N - 3 * i) % 5 == 0) {
					sb.append(i + (N - 3  * i) / 5);
					break;
				}
				if(i == N / 3 && N % 3 != 0) {
					sb.append(-1);
				}
			}
		}
		
		System.out.println(sb);
	}
}