import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = 9;
		
		int[][] board = new int[N][N];
		int max = -1;
		int r = 0;
		int c = 0;
		for(int i = 1 ; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(max < num) {
					max = num;
					r = i;
					c = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(r + " " + c);
	}
}
