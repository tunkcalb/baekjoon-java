import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	
	private static boolean[] isSelected; // 선택 여부
	private static int[] numbers; // 하나의 경우의 수 저장
	private static int[] input; // 집합
	
	public static void main(String[] args) throws Exception {
	
		/**
		 * 1. 입력파일 읽어들이기
		 */
	
		//System.setIn(new FileInputStream("res/15649_input2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		/**
		 * 2. 입력파일 객체화
		 */
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		/**
		 * 3. 알고리즘 풀기
		 */
	
		isSelected = new boolean[N];
		numbers = new int[M];
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
			
		}
		permutation(0);
		
		/**
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}
	//cnt: 뽑은 수의 개수
	private static void permutation(int cnt) {
		// TODO Auto-generated method stub
		// 기저부분
		if (cnt == M) {
			for (int number : numbers) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 유도부분
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) {
				continue;
			}
			numbers[cnt] = input[i];
			isSelected[i] = true;
			
			//다음수 뽑으러 가기
			permutation(cnt + 1);
			
			//사용했던 수에 대한 선택 되돌리기
			isSelected[i] = false;
		}
	}
	
	
	
}