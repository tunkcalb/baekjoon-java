import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	private static int S;
	private static int P;
	private static int cnt;
	private static int answer;
	private static char[] dna = {'A', 'C', 'G', 'T'};
	private static String DNA;
	private static HashMap<Character,int[]> hm = new HashMap<Character, int[]>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		DNA = in.readLine();
		st = new StringTokenizer(in.readLine());
		for (char c : dna) {
			hm.put(c, new int[] {0, Integer.parseInt(st.nextToken())});
		}
		
		for (int i = 0; i < P; i++) {
			hm.get(DNA.charAt(i))[0]++;
		}
		if(isFull()) answer ++;
		for (int i = 0; i < S-P; i++) {
			hm.get(DNA.charAt(i))[0]--;
			hm.get(DNA.charAt(i + P))[0]++;
			if(isFull()) answer ++;
		}
		System.out.println(answer);

	}
	public static boolean isFull() {
		for (char c : dna) {
			if (hm.get(c)[0] < hm.get(c)[1]) return false;
		}
		return true;

	}
}