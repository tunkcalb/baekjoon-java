import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String newbie = "";
		if(M <= 2) {
			newbie = "NEWBIE!";
		}
		else if (M <= N) {
			newbie = "OLDBIE!";
		}
		else {
			newbie = "TLE!";
		}
		System.out.println(newbie);
	}
}
