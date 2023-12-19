import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int size = st.countTokens();
		int cnt = 0;
		
		for(int i = 0; i < size; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == N) cnt++;
		}
		System.out.println(cnt);
	}
}
