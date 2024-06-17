import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = 0;
        int[] cnt = new int [1001];
        for(int i = 0; i < 10; i++){
            int num = Integer.parseInt(in.readLine());
            sum += num;
            cnt[num]++;
            
        }

        int index = 0;
        int max = 0;
        for(int i = 0; i < 1001; i++){
            if(max < cnt[i]){
                max = cnt[i];
                index = i;
            }
        }

        System.out.println((sum/10));
        System.out.println(index);
	}
}
