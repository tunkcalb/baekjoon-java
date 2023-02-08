import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

		private static int N;
		private static int M;
		
		private static int[] input;  
		private static int[] numbers;  

		private static StringBuilder sb = new StringBuilder();

		public static void main(String[] args) throws Exception {

		
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			
			String[] split = in.readLine().split(" ");
			N = Integer.parseInt(split[0]);
			M = Integer.parseInt(split[1]);

			
			input = new int[N];
			numbers = new int[M];
			
			for (int i = 0; i < N; i++) {
				input[i] = i + 1;
			}
			
			
			combination(0, 0);

			/**
			 * 4. 정답 출력
			 */
			System.out.println(sb);
		}

		
		private static void combination(int cnt, int start) {
		
		
			if (cnt == M) {
				for (int number : numbers) {
					sb.append(number).append(" ");
				}
				sb.append("\n");
				return;
			}
			
	
			for (int i = start; i < N; i++) {
				
				numbers[cnt] = input[i];
				
				combination(cnt + 1, i + 1); 
			}
			
		}
	}