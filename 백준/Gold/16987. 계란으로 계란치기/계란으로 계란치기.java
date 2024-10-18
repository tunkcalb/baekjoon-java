import java.io.*;
import java.util.*;

public class Main {
	
	static Egg[] eggs;
	static int N;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		eggs = new Egg[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(s, w);
		}
		
		max = 0;
		dfs(0);
		System.out.println(max);
	}
	
	public static void dfs(int idx) {
		if(idx == N) {
			int sum = 0;
			for(Egg egg : eggs) {
				if(egg.s <= 0) sum++;
			}
			max = Math.max(sum, max);
			return;
		}
		
		
		if(eggs[idx].s > 0) {
			boolean isCrush = false;
			for(int i = 0; i < N; i++) {
				if(idx == i) continue;
				if(eggs[i].s <= 0) continue;
				isCrush = true;
				
				eggs[i].s -= eggs[idx].w;
				eggs[idx].s -= eggs[i].w;
				dfs(idx + 1);
				
				eggs[i].s += eggs[idx].w;
				eggs[idx].s += eggs[i].w;
			}
			if(!isCrush) dfs(idx + 1);
		} else dfs(idx + 1);
	}
	
	static class Egg {
		int s;
		int w;
		
		Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}
}
