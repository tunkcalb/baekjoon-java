import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public abstract class Main {

	static int n, m;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());

			int num = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (num == 0) {
				union(a, b);
			} else if (num == 1) {
				int A = find(a);
				int B = find(b);
				if(A == B) System.out.println("YES");
				else System.out.println("NO");
			}
		}

	}

	private static void union(int a, int b) {
		int A = find(a);
		int B = find(b);

		parent[B] = A;
	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		parent[a] = find(parent[a]);

		return parent[a];
	}

}
