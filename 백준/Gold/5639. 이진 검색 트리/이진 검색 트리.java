import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int rootNum = Integer.parseInt(in.readLine());
		
		Node root = new Node(rootNum);
		
		String nextNum = "";
		while((nextNum = in.readLine()) != null) {
			int next = Integer.parseInt(nextNum);
			
			findNext(root, next);
		}
		
		sb = new StringBuilder();
		search(root);
		System.out.println(sb);
	}
	
	private static void search(Node now) {
		
		if(now.left != null) search(now.left);
		if(now.right != null) search(now.right);
		
		sb.append(now.num).append("\n");
	}

	private static void findNext(Node parent, int next) {
		if(parent.num > next) {
			if(parent.left == null) {
				parent.left = new Node(next);
			}
			else findNext(parent.left, next);
		}
		else {
			if(parent.right == null) {
				parent.right = new Node(next);
			}
			else findNext(parent.right, next);
		}
		
	}

	static class Node {
		int num;
		Node left;
		Node right;
		
		Node(int num) {
			this.num = num;
		}
	}
}
