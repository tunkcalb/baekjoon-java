import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> pocket1 = new HashMap<>();
		HashMap<String, String> pocket2 = new HashMap<>();
		
		for(int i = 1 ; i <= N; i++) {
			String mon = in.readLine();
			pocket1.put(mon, String.valueOf(i));
			pocket2.put(String.valueOf(i), mon);
		}
		
		for(int i = 0; i < M; i++) {
			
			String question = in.readLine();
			String ans = pocket1.get(question);
			
			if(ans == null) ans = pocket2.get(question);
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
}