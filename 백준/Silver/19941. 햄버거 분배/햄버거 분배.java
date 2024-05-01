import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] ate;
	static String line;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		line = in.readLine();
		ate = new boolean[N];
		cnt = 0;
		idx : for(int i = 0; i < N; i++) {
			if(line.charAt(i) == 'P') {
				for(int j = i - K; j < i; j++) {
					if(canEat(j)) {
						continue idx;
					}
				}
				for(int j = i + 1; j <= i + K; j++) {
					if(canEat(j)) {
						continue idx;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	private static boolean canEat(int j) {
		if(j < 0 || j > line.length() - 1) return false;
		if(line.charAt(j) == 'H' && !ate[j]) {
			ate[j] = true;
			cnt++;
			return true;
		}
		return false;
	}
}
