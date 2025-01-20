import java.io.*;
import java.util.*;

public class Main {
	
	static Node[] tree;
	static StringBuilder pre;
	static StringBuilder in;
	static StringBuilder post;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		char root = 'A';
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char now = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if(tree[now - 'A'] == null) {
				tree[now - 'A'] = new Node(now);
			}
			if(left != '.') {
				tree[left - 'A'] = new Node(left);
				tree[now - 'A'].left = tree[left - 'A'];
			}
			if(right != '.') {
				tree[right - 'A'] = new Node(right);
				tree[now - 'A'].right = tree[right - 'A'];
			}
			
			if(i == 0) {
				root = now;
			}
		}
		
		pre = new StringBuilder();
		in = new StringBuilder();
		post = new StringBuilder();
		
		dfs(root);
		
		StringBuilder sb = new StringBuilder();
		sb.append(pre.toString()).append("\n");
		sb.append(in.toString()).append("\n");
		sb.append(post.toString());
		
		System.out.println(sb);
	}
	
	private static void dfs(char now) {
		pre.append(now);
		if(tree[now - 'A'].left != null) {
			dfs(tree[now - 'A'].left.now);
		}
		
		in.append(now);
		if(tree[now - 'A'].right != null) {
			dfs(tree[now - 'A'].right.now);
		}
		
		post.append(now);
	}

	static class Node {
		char now;
		Node left;
		Node right;
		
		Node(char now) {
			this.now = now;
		}
	}
}
