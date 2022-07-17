import java.util.Scanner;

public class SWEA_1979 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int tc = 0; tc < T; tc++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            int[][] arr = new int[N][N];
            int result = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }

            for(int i = 0; i < N; i++) {
                int cntR = 0;
                int cntC = 0;
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] == 1) {
                        cntR++;
                    }
                    if(arr[i][j] == 0 || j == N - 1) {
                        if(cntR == K) {
                            result++;
                        }
                        cntR = 0;
                    }

                    if(arr[j][i] == 1) {
                        cntC++;
                    }
                    if(arr[j][i] == 0 || j == N - 1) {
                        if(cntC == K) {
                            result++;
                        }
                        cntC = 0;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc + 1, result);
        }
    }
}





