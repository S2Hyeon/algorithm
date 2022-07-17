import java.util.Scanner;

public class SWEA_1961 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int tc = 0; tc < T; tc++) {
            int N = scan.nextInt();
            int[][] arr = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }
            System.out.printf("#%d\n",tc + 1);
            for(int i = 0; i < N; i++) {
                for(int j = N - 1; j >= 0; j--) {
                    System.out.print(arr[j][i]);
                }
                System.out.print(" ");
                for(int j = N - 1; j >= 0; j--) {
                    System.out.print(arr[N - 1 - i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++) {
                    System.out.print(arr[j][N - 1 - i]);
                }
                System.out.println();
            }
        }


    }
}



