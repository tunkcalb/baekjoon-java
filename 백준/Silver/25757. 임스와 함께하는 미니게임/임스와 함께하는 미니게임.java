import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		
		Set<String> set = new HashSet<>();
		for(int t = 0; t < N; t++) {
			set.add(br.readLine());
		}
		
		if(game.equals("Y")) {
			System.out.println(set.size());
		}
		else if(game.equals("F")) {
			System.out.println(set.size() / 2);
		}
		else {
			System.out.println(set.size() / 3);
		}
		
	}
}
