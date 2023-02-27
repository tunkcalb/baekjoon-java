import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static boolean[][] board;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int cnt;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int size = 101;
		N = Integer.parseInt(in.readLine());
		
		
		board = new boolean[size][size];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 검은 스카프 영역 true로 표시
			for(int dx = 0; dx < 10; dx++) {
				for(int dy = 0; dy < 10; dy++) {
					board[x + dx][y + dy] = true;
				}
			}
		}
		// 검은스카프 영역이지만 주변에 하얀스카프가 있으면 수를 하나씩 더함
		// 둘레를 구하기 때문에 하나의 검은 스카프 영역에 두개의 하얀스카프 영역이 있어도 각각 더해줌
		for(int r = 1; r < size; r++) {
			for(int c = 1; c < size; c++) {
				if(board[r][c] == true) {
					for(int i = 0; i < 4; i++) {
						if(board[r + dr[i]][c + dc[i]] == false) cnt++;
					}
					
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}