import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 0 ; tc < T; tc++) {
			
			int N = Integer.parseInt(in.readLine());
			HashMap<String, Integer> hashMap = new HashMap<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				st.nextToken();
				String wear = st.nextToken();
				if(hashMap.get(wear) == null) {
					hashMap.put(wear, 1);
				}else {
					hashMap.put(wear, hashMap.get(wear) + 1);
				}
			}
			
			int answer = 1;
			for(int val : hashMap.values()) {
				answer *= val + 1;
			}
			System.out.println(answer - 1);
		}
	}
}
