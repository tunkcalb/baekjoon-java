import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int N = 26;
		int[] aCnt = new int[N];
		int[] bCnt = new int[N];
		
		for(int i = 0 ; i < a.length(); i++) {
			aCnt[a.charAt(i) - 'a']++;
		}
		for(int i = 0 ; i < b.length(); i++) {
			bCnt[b.charAt(i) - 'a']++;
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			cnt += Math.abs(aCnt[i] - bCnt[i]);
		}
		
		System.out.println(cnt);
	}
}
