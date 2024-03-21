import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<String> set = new HashSet<>();
		
		int N = Integer.parseInt(in.readLine());
		
		set.add("ChongChong");
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String A = st.nextToken();
			String B = st.nextToken();
			
			if(set.contains(A) || set.contains(B)) {
				set.add(A);
				set.add(B);
			}
		}
		System.out.println(set.size());
	}
}
