import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double nums[] = new double[N];
		
		double max = 0;
		for(int i = 0; i < N; i++) {
			nums[i] = Double.parseDouble(sc.next());
			
			if (nums[i] > max) max = nums[i];
		}
		double ans = 0;
		for(int i = 0; i < N; i++) {
			ans += nums[i] / max * 100;
		}
		
		ans /= N;
		
		System.out.println(ans);
	}
}
