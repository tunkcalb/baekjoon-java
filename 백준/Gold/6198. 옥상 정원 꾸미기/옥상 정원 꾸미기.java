import java.io.*;
import java.util.*;

public class Main {

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt( br.readLine() );

        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt( br.readLine() );

            while( !stack.isEmpty() ) {
                if( stack.peek() <= num ) {
                    stack.pop();
                } else break;
            }
            sum += stack.size();
            stack.push(num);
        }

        System.out.println(sum);
    }
}
