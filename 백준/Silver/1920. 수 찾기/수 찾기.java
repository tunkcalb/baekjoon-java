import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}
