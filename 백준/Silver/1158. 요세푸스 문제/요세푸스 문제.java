import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		sb.append("<");
		List<Integer> yose = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			yose.add(i);
		}
		int idx = -1;
		for (int i = 0; i < N; i++) {
			
			idx += K;
			
			idx %= yose.size();
			if(i != N-1) {
			sb.append(yose.get(idx)).append(", ");
			}
			else {
				sb.append(yose.get(idx));
			}
			yose.remove(idx);
			idx -= 1;
		}
		sb.append(">");
	
		System.out.println(sb);
	
	}
}