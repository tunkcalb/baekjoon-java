import java.io.*;
import java.util.*;

public class Main {
	
	static String s;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			s = br.readLine();
			cnt = 0;
			sb.append(isPalindrome()).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	 public static int isPalindrome(){
        return recursion(0, s.length()-1);
	 }
	 
    public static int recursion(int l, int r){
    	cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(l+1, r-1);
    }
}
