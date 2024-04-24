import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		int unit = Integer.MAX_VALUE;
		int pack = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			pack = Math.min(pack,Integer.parseInt(st.nextToken()));
			unit = Math.min(unit,Integer.parseInt(st.nextToken()));
		}
		
		min = Math.min(min, pack * (N / 6) + unit * (N % 6));
		min = Math.min(min, pack * (N / 6 + 1));
		min = Math.min(min, unit * N);
		System.out.println(min);
	}
}
