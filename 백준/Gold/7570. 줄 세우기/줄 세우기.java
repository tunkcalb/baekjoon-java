import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] line = new int[N + 1];
		int[] position = new int[N + 2];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 1; i <= N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
			position[line[i]] = i;
		}
		
		int max = 1;
		
		for(int i = 1; i < N; i++) {
			int now = i;
			int idx = line[i] + 1; 
			int next = position[idx];
			
			int len = 1;
			
			while(next > now){
				now = position[idx];
				next = position[++idx];
				len++;
				
			}
			if(max < len) max = len;
		}
		
		System.out.println(N - max);
	}
}