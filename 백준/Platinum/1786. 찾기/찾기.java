import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		char[] T = in.readLine().toCharArray();
		char[] P = in.readLine().toCharArray();

		int tLength = T.length;
		int pLength = P.length;

		int[] pi = new int[pLength];

		for (int i = 1, j = 0; i < pLength; i++) {

			while (j > 0 && P[i] != P[j]) {
				j = pi[j - 1]; 
			}

			if (P[i] == P[j]) {
				pi[i] = ++j;
			}
			else {
				pi[i] = 0;
			}
		}

		int cnt = 0;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0, j = 0; i < tLength; i++) { 

			while (j > 0 && T[i] != P[j]) {
				j = pi[j - 1]; 
			}

			if (T[i] == P[j]) { 

				if (j == pLength - 1) { 
					cnt++; 
					list.add(i - (pLength - 1)); 

					j = pi[j]; 
				}
				else {
					j++;
				}
			}
		}

		sb.append(cnt).append("\n");
		if (cnt > 0) {
			for (Integer i : list) {
				sb.append(i + 1).append(" ");
			}
		}

		System.out.println(sb);
	}
}