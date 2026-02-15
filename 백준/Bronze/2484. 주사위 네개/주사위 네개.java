import java.io.*;
import java.util.*;

public class Main {
	
	static int N = 4;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int max = 0;
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int money = cal(a, b, c, d);
			max = Math.max(max, money);
		}
		
		System.out.println(max);
	}
	
	private static int cal(int a, int b, int c, int d) {
	    int[] arr = {a, b, c, d};
	    Arrays.sort(arr);
	    
	    if(arr[0] == arr[3]) {
	        return 50000 + arr[0] * 5000;
	    }
	    
	    if(arr[0] == arr[2] || arr[1] == arr[3]) {
	        return 10000 + arr[1] * 1000;
	    }
	    
	    if(arr[0] == arr[1] && arr[2] == arr[3]) {
	        return 2000 + (arr[0] + arr[2]) * 500;
	    }
	    
	    if(arr[0] == arr[1]) return 1000 + arr[0] * 100;
	    if(arr[1] == arr[2]) return 1000 + arr[1] * 100;
	    if(arr[2] == arr[3]) return 1000 + arr[2] * 100;
	    
	    return arr[3] * 100;
	}
}
