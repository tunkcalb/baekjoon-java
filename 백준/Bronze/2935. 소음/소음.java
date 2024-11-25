import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger a = new BigInteger(in.readLine());
        String op = in.readLine();
        BigInteger b = new BigInteger(in.readLine());
        if (op.equals("*")) {
            System.out.print(a.multiply(b));
        } else {
            System.out.print(a.add(b));
        }
	}
}
