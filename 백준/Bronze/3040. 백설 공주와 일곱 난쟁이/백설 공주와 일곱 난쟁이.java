import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int N;
	private static int full;
	private static int[] nine;
	private static boolean[] isSelected;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = 9;
		full = 7;
		nine = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			nine[i] = Integer.parseInt(in.readLine());
		}
		
		permutation(0,0);
		
		System.out.println(sb);
	}


	private static void permutation(int cnt, int start) {
		if (cnt == full) {
			int total = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i] == true) {
					total += nine[i];
				}
			}
			if(total == 100) {
				for(int i = 0; i < N; i++) {
					if(isSelected[i] == true) {
						sb.append(nine[i]).append("\n");
					}
				}
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			isSelected[i] = true;
			permutation(cnt + 1, i + 1);
			isSelected[i] = false;
		}
		
	}
}