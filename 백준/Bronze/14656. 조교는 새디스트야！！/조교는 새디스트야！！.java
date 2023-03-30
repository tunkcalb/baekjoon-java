import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int [] line = new int[N];
		
		for(int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(line[i] != i + 1) cnt++;
		}
		
		System.out.println(cnt);
	}
}