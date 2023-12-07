import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String num1 = st.nextToken();
		String num2 = st.nextToken();
		
		String revNum1 = "";
		String revNum2 = "";
		
		
		
		for(int i = num1.length() - 1; i >= 0; i--) {
			revNum1 += num1.charAt(i);
		}
		for(int i = num2.length() - 1; i >= 0; i--) {
			revNum2 += num2.charAt(i);
		}
		
		int sum = 0;
		
		sum += Integer.parseInt(revNum1);
		sum += Integer.parseInt(revNum2);
		
		String ans = "";
		
		for(int i = String.valueOf(sum).length() - 1; i >= 0; i--) {
			ans += String.valueOf(sum).charAt(i);
		}
		System.out.println(Integer.parseInt(ans));
	}
}
