import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] nums = new int[N];
		String ans = "-1";
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		if(prePermutation(nums)) {
			for(int i : nums) {
				System.out.print(i + " ");
			}
		}
		else System.out.println(-1);
	}
	
	public static boolean prePermutation(int[] arr) {
		int i = arr.length-1;
		
		while(i > 0 && arr[i] > arr[i-1]) {
			i--;
		}

		if(i == 0) 
			return false;
		
		int j = arr.length-1;
		while(arr[i-1] < arr[j]) {
			j--;
		}
		swap(arr, i-1, j);
		
		j = arr.length-1;
		while(i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
