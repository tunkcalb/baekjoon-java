import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = 3;
		int[][] score = new int[N][M + 1];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 1; j <= M; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= M; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int j = 0; j < N; j++) {
				if(!map.containsKey(score[j][i])) map.put(score[j][i], 1);
				else map.put(score[j][i], 2);
			}
			
			for(int j = 0; j < N; j++) {
				if(map.get(score[j][i]) != 1) score[j][i] = 0;
				score[j][0] += score[j][i];
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.println(score[i][0]);
		}
	}
}
