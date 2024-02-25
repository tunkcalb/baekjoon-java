public class Test {
    long sum(int[] a) {
		int len = a.length;
		
		long sum = 0;
		for(int i = 0; i < len; i++) {
			sum += a[i];
		}
		return sum;
	}
}