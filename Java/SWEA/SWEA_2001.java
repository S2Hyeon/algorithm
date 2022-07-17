import java.util.Scanner;

public class SWEA_2001 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int tc = 0; tc < T; tc++) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int[][] arr = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }

            int sum = 0;
            int max = 0;
            for(int i = 0; i < N - M + 1; i++) {
                for(int j = 0; j < N - M + 1; j++) {
                    for(int k = 0; k < M; k++) {
                        for(int l = 0; l < M; l++) {
                            sum += arr[i + k][j + l];
                        }
                    }
                    if(max < sum)
                        max = sum;
                    sum = 0;
                }
            }

            System.out.printf("#%d %d\n", tc + 1, max);
        }


    }
}



