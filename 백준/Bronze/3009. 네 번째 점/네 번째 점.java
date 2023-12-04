import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> x = new ArrayList<>();
		List<String> y = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String newX = st.nextToken();
			String newY = st.nextToken();
			
			if(x.contains(String.valueOf(newX))) x.remove(String.valueOf(newX));
			else x.add(newX);
			if(y.contains(String.valueOf(newY))) y.remove(String.valueOf(newY));
			else y.add(newY);
		}
		StringBuilder sb = new StringBuilder();
		
		sb.append(x.get(0)).append(" ").append(y.get(0));
		System.out.println(sb);
	}
}
