import java.util.Scanner;

public class SWEA_1959 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int tc;

        for(tc = 0; tc < T; tc++) {
            int lengthA = scan.nextInt();
            int lengthB = scan.nextInt();
            int max = 0;
            int[] a = new int[lengthA];
            int[] b = new int[lengthB];

            for(int i = 0; i < lengthA; i++) {
                a[i] = scan.nextInt();
            }

            for(int i = 0; i < lengthB; i++) {
                b[i] = scan.nextInt();
            }

            if(lengthA > lengthB) {
                int[] temp = a;
                a = b;
                b = temp;
            }

            for(int i = 0; i < b.length - a.length + 1; i++) {
                int sum = 0;
                for(int j = 0; j < a.length; j++) {
                    sum += a[j] * b[i + j];
                }
                if(sum > max) {
                    max = sum;
                }
            }
            System.out.printf("#%d %d\n", tc + 1, max);
        }

    }
}



