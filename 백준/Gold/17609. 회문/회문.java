import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			String word = in.readLine();

			int left = 0;
			int right = word.length() - 1;
			int cnt = 0;

			if (!new StringBuilder(word).reverse().toString().equals(word.toString())) {
				while (left < right) {
					if (word.charAt(left) != word.charAt(right)) {
						StringBuilder delLeft = new StringBuilder(word).deleteCharAt(left);
						StringBuilder delRight = new StringBuilder(word).deleteCharAt(right);

						if (delLeft.toString().equals(delLeft.reverse().toString()) || delRight.toString().equals(delRight.reverse().toString())) cnt = 1;
						else cnt = 2;
						break;
					}
					left++;
					right--;
				}
			}
			sb.append(cnt);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
