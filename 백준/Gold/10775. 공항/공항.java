import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int G, P;
	static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(in.readLine());
		P = Integer.parseInt(in.readLine());
		
		parent = new int[G + 1];
		
		for(int i = 1; i <= G; i++) {
			parent[i] = i;
		}
		
		int ans = 0;
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(in.readLine());
			int emptyGate = find(g);
			
			if (emptyGate == 0) {
				break;
			}
			
			ans++;
			union(emptyGate, emptyGate - 1);
		}
		System.out.println(ans);
	}

	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[x] = y;
		}
	}
}
