import java.util.Scanner;

public class SWEA_1974 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int tc = 0; tc < T; tc++) {
            int N = 9;
            int[][] arr = new int[N][N];
            int[] check;
            int result = 1;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }

            for(int i = 0; i < N; i++) {
                check = new int[N + 1];
                for(int j = 0; j < N; j++) {
                    check[arr[i][j]] = 1;
                }
                for(int j = 1; j <= N; j++) {
                    if(check[j] == 0)
                        result = 0;
                }
            }

            for(int i = 0; i < N; i++) {
                check = new int[N + 1];
                for(int j = 0; j < N; j++) {
                    check[arr[j][i]] = 1;
                }
                for(int j = 1; j <= N; j++) {
                    if(check[j] == 0)
                        result = 0;
                }
            }

            for(int i = 0; i < N; i += 3) {
                check = new int[N + 1];
                for(int j = 0; j < N; j += 3) {
                    for(int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            check[arr[i + k][j + l]] = 1;
                        }
                    }
                    for(int k = 1; k <= N; k++) {
                        if(check[k] == 0)
                            result = 0;
                    }
                }
            }

            System.out.printf("#%d %d\n", tc + 1, result);
        }


    }
}



