import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 3; i++) {
			BigInteger S = new BigInteger("0");
			int N = Integer.parseInt(br.readLine());
			
			for(int j = 0; j < N; j++) {
				BigInteger N2 = new BigInteger(br.readLine());
				S = S.add(N2);
			}
			
			if(S.compareTo(BigInteger.ZERO) == -1) {
				sb.append("-").append("\n");
			}
			else if(S.compareTo(BigInteger.ZERO) == 1) {
				sb.append("+").append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
