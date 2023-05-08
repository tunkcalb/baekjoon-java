import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		int num = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			num = 0;
			num += Integer.parseInt(st.nextToken());
			num += Integer.parseInt(st.nextToken());
			sb.append(num).append("\n");
		}
		
		System.out.println(sb);
	}
}
