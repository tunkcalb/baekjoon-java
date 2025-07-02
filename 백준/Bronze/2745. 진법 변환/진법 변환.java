import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
	    int B = Integer.parseInt(st.nextToken());
	    
	    int tmp = 1;
	    int sum = 0;
	    
	    for(int i = N.length() - 1; i >= 0; i--) {
	    	char c = N.charAt(i);
	    	
	    	if('0' <= c && c <= '9') {
	    		sum += (c - '0') * tmp;
	    	}
	    	else {
	    		sum += (c - 'A' + 10) * tmp;
	    	}
	    	tmp *= B;
	    }
	    
	    System.out.println(sum);
	}
}
