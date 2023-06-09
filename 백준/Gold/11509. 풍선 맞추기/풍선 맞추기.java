import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int cnt;
	static int[] arrow;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] balloon = new int[N];
		for(int i = 0; i < N; i++) {
			balloon[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		arrow = new int[1000001];
		for(int i = 0; i < N; i++) {
			int height = balloon[i];
			if(arrow[height] == 0) {
				cnt++;
			}else if (arrow[height] > 0) {
				arrow[height] -= 1;
			}
			arrow[height - 1]++;
		}
		System.out.println(cnt);
	}
}
