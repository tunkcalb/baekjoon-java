import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 5;
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(in.readLine());
		}
		
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		while(true) {
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				String line = list.get(i);
				if(line.length() > idx) {
					sb.append(line.charAt(idx));
				}
				else cnt++;
			}
			idx++;
			if(cnt == N) break;
		}
		System.out.print(sb);
	}
}
