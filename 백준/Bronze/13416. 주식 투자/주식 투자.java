import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int sum;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		for(int n = 0; n < N; n++) {
			sum = 0;
			int day = Integer.parseInt(in.readLine());
			for(int i = 0; i < day; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int temp = 0;
				for(int j = 0; j < 3; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num > temp) temp = num;
				}
				sum += temp;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}