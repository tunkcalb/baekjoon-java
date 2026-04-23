import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int rst = 360;
        for(int temp : arr) rst = gcd(rst, temp);
        st = new StringTokenizer(br.readLine());
        
        while(st.hasMoreTokens()){
            if(Integer.parseInt(st.nextToken()) % rst == 0) {
            	sb.append("YES").append("\n");
            }
            else sb.append("NO").append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    static int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
