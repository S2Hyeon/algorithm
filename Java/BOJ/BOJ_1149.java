import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1149 RGB 거리
public class BOJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 3; j++) {
                // 현재 집의 색과 겹치지 않는 이전 두 집의 비용중 작은 비용을 현재 집의 색과 더한값을 저장한다.
                // => 현재 집까지의 최소비용이 각 색의 위치(j = 0, 1, 2)에 저장된다
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + dp[i][j];
            }
        }
        // 마지막 집에서의 최소 값이 최소비용이 된다.
        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}
