import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA_5643 키 순서
public class SWEA_5643 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = Integer.MAX_VALUE >> 3;	// 오버플로우 방지
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());	// 학생 수
            int M = Integer.parseInt(br.readLine());	// 간선 수
            int result = 0;

            int[][] map = new int[N + 1][N + 1];

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i != j) {
                        map[i][j] = INF;
                    }
                }
            }

            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = 1;
            }

            for(int k = 1; k <= N; k++) {
                for(int i = 1; i <= N; i++) {
                    for(int j = 1; j <= N; j++) {
                        if(map[i][k] + map[k][j] < map[i][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            for(int i = 1; i <= N; i++) {
                int cnt = 0;
                for(int j = 1; j <= N; j++) {
                    // 자기 자신을 제외하고 자신보다 큰 사람이 있거나 작은사람이 있다면 카운트 증가
                    if(i != j && (map[i][j] != INF || map[j][i] != INF)) {
                        cnt++;
                    }
                }
                if(cnt == N - 1)	// 자기 자신을 제외하고 모든 정점과 연결되어있다면
                    result++;
            }
            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
