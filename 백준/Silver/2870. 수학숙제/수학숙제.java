import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	static int N;
	static List<BigInteger> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			getNum(line);
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(BigInteger num : list) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}

	private static void getNum(String line) {
		
		String tmp = "";
		
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if(Character.isDigit(c)) {
				tmp += c;
			}
			else {
				if(tmp != "") {
					list.add(new BigInteger(tmp));
					tmp = "";
				}
			}
		}
		
		if(tmp != "") {
			list.add(new BigInteger(tmp));
		}
	}
}
