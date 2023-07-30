import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String name = st.nextToken();
			String act = st.nextToken();
			
			if(act.equals("enter")) set.add(name);
			else set.remove(name);
		}
		
		Object[] names = set.toArray();
		
		Arrays.sort(names, Collections.reverseOrder());
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
}
