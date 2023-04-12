import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		NGE();
		print();
	}

	private static void print() {
		for(int i = 0; i < N; i++) {
			sb.append(nums[i] + " ");
		}
		System.out.println(sb);
	}

	private static void NGE() {
		Deque<Integer> stack = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				nums[stack.pop()] = nums[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}
		
	}
}