import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int cnt, N, r, c;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int size = 1 << N;
		z(0, 0, size);

	}

	private static void z(int row, int col, int size) {
		if(size == 1) {
			System.out.println(cnt);
			return;
		}
		size = size / 2;

		// 좌상
		if (row + size > r && col + size > c) {
			z(row, col, size);
		}
		// 우상
		if(row + size > r && col + size <= c) {
			cnt += size * size;
			z(row, col + size, size);	
		}
		// 좌하
		if(row + size <= r && col + size > c) {
			cnt += size * size * 2;
			z(row + size, col, size);			
		}
		// 우하
		if(row + size <= r && col + size <= c) {
			cnt += size * size * 3;
			z(row + size, col + size, size);			
		}
	}

}