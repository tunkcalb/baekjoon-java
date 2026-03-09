import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int[] aCards = new int[5];
            int numA = sc.nextInt();
            for (int j = 0; j < numA; j++) {
                aCards[sc.nextInt()]++;
            }

            int[] bCards = new int[5];
            int numB = sc.nextInt();
            for (int j = 0; j < numB; j++) {
                bCards[sc.nextInt()]++;
            }

            char result = 'D';
            for (int j = 4; j >= 1; j--) {
                if (aCards[j] > bCards[j]) {
                    result = 'A';
                    break;
                } else if (bCards[j] > aCards[j]) {
                    result = 'B';
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
