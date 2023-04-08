import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] conference;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		conference = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			conference[i][0] = Integer.parseInt(st.nextToken());
			conference[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(conference, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1]) {
					return o1[0] - o2[1];
				}
				
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int end = 0;
		
		for(int i = 0; i < N; i++) {
			if(conference[i][0] >= end) {
				end = conference[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}