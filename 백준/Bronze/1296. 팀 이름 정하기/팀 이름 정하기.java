import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String green = in.readLine();
		int L = 0;
		int O = 0;
		int V = 0;
		int E = 0;
		
		for(int i = 0; i < green.length(); i++) {
			char spelling = green.charAt(i);
			
			if(spelling == 'L') L++;			
			if(spelling == 'O') O++; 
			if(spelling == 'V') V++;
			if(spelling == 'E') E++;
		}
		
		int N = Integer.parseInt(in.readLine());
		
		String ans = "";
		int max = -1;
		
		String[] teams = new String[N];
		
		for(int i = 0; i < N; i++) {
			teams[i] = in.readLine();
		}
		
		Arrays.sort(teams);
		for(String team : teams) {
			int percent = cal(L, O, V, E, team);
			
			if(max < percent) {
				max = percent;
				ans = team;
			}
		}
		System.out.println(ans);
	}

	private static int cal(int L, int O, int V, int E, String team) {
		
		for(int i = 0; i < team.length(); i++) {
			char spelling = team.charAt(i);
			
			if(spelling == 'L') L++;			
			if(spelling == 'O') O++; 
			if(spelling == 'V') V++;
			if(spelling == 'E') E++;
		}
		
		return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
	}
}
