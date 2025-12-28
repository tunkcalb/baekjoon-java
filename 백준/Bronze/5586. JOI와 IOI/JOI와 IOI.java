import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		int joi = 0;
		int ioi = 0;
		
		for(int i = 0; i < line.length() - 2; i++) {
			if(line.subSequence(i, i + 3).equals("JOI")) {
				joi++;
			}
			else if (line.subSequence(i, i + 3).equals("IOI")){
				ioi++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(joi).append("\n");
		sb.append(ioi);
		System.out.println(sb);
	}
}
