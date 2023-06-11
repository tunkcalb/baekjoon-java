import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if (name.equals("#") && age == 0 && weight == 0) break;
			String ans;
			if(age > 17 || weight >= 80) {
				ans = "Senior";
			}
			else ans = "Junior";
			
			System.out.println(name + " " + ans);
		}
		
	}
}
