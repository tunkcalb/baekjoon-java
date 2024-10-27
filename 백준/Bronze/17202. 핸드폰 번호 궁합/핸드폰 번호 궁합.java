import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s1 = in.readLine();
		String s2 = in.readLine();
		
		String s = "";
		for(int i = 0; i < s1.length(); i++) {
			s += s1.charAt(i);
			s += s2.charAt(i);
		}
		while(s.length() > 2) {
			String newS = "";
			for(int i = 0; i< s.length() - 1; i++) {
				int n = (s.charAt(i) - '0') + (s.charAt(i + 1) - '0');
				newS += n % 10;
			}
			s = newS;
		}
		System.out.println(s);
	}
}
