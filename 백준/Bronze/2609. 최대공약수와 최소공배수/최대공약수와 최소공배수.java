import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	private static int num1;
	private static int num2;
	private static int divisor;
	private static int multiple;

	public static void main(String[] args) throws Exception {

		/**
		 * 1. 입력파일 읽어들이기
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		/**
		 * 2. 입력파일 객체화
		 */
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		/**
		 * 3. 알고리즘 풀기
		 */
		divisor = num1 > num2 ? num2:num1;
		multiple = 0;
		while(true) {
			
			if(num1 % divisor == 0 && num2 % divisor == 0) {
				break;
			}
			divisor--;
		}
		
		multiple = num1 * num2 /divisor;
		/**
		 * 4. 정답 출력
		 */
		sb.append(divisor).append("\n");
		sb.append(multiple);
		System.out.println(sb);
	}
}