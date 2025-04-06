import java.io.*;
import java.util.*;

public class Main {
	
	static char[] duck = {'q', 'u', 'a', 'c', 'k'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		if(arr.length % 5 != 0) {
			System.out.println(-1);
			return;
		}
		
		int len = arr.length;
		int cnt = 0;
		
		while(len != 0) {
			int pt = 0;
			int idx = 0;
			boolean check = false;
			int[] quack = new int[5];
			while(idx < arr.length) {
				if(arr[idx] == duck[pt]) {
					quack[pt++] = idx;
					if(pt == 5) {
						check = true;
						len -= 5;
						pt = 0;
						for(int i = 0; i < 5; i++) arr[quack[i]] = '0';
					}
				}
				idx++;
			}
			if(check) cnt++;
			else break;
		}
		System.out.println(len == 0? cnt : -1);
	}
}
