import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int size;
	static int[] perm;
	static List<Integer> nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> temp = new HashSet<>();
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			temp.add(Integer.parseInt(st.nextToken()));
		}
		
		size = temp.size();
		nums = new ArrayList<>(temp);
		Collections.sort(nums);
		perm = new int[M];
		permutation(0, 0);
		System.out.println(sb);
	}

	private static void permutation(int cnt, int start) {
		
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(perm[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < size; i++) {
			perm[cnt] = nums.get(i);
			permutation(cnt + 1, i);
		}
	}
}
