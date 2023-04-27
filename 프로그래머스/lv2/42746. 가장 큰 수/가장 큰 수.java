import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
       StringBuilder sb = new StringBuilder();
		int size = numbers.length;
		
		String[] line = new String[size];
		
		for(int i = 0; i < size; i++) {
			line[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(line, new Comparator<String>() {

			@Override
			public int compare(String num1, String num2) {
				return (num2 + num1 ).compareTo(num1 + num2);
			}
		});
		
        if(line[0].equals("0")) return "0";
		for(int i = 0; i < size; i++) {
			sb.append(line[i]);
		}
		
		return sb.toString();
    }
}