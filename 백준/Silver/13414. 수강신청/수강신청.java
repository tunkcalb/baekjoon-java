import java.io.*;
import java.util.*;

public class Main {
	
	static int K, L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
		for(int i = 0; i < L; i++) {
			String str = br.readLine();
			
			if(set.contains(str)) set.remove(str);
			set.add(str);
		}
		
		int cnt = 0;
		for(String str : set) {
			cnt++;
			System.out.println(str);
			if(cnt == K) break;
		}
	}
}
