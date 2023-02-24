import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();
	private static int L, C;
	private static char[] ward;
	private static char[] answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		answer = new char[L];
		ward = new char[C];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < C; i++) {
			ward[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(ward);
		
		permutation(0, 0);
		System.out.println(sb);
	}

	private static void permutation(int cnt, int start) {
		if(cnt == L) {
			if(!isValid()) return;
			for(int i = 0; i < L; i++) {
				sb.append(answer[i]);
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < C; i++) {
			answer[cnt] = ward[i];
			permutation(cnt + 1, i + 1);
		}
		
	}
	
	private static boolean isValid() {
		int mo = 0;
		int ja = 0;
		
		for(char i : answer) {
			if(i == 'a' ||i == 'e' ||i == 'i' ||i == 'o' ||i == 'u') {
				mo++;
			}else ja++;
			
		}
		if(mo >= 1 && ja >= 2) return true;
		else return false;
		
	}
	
}