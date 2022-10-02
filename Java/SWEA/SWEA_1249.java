import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// SWEA_1249 [S/W 문제해결 응용] 4일차 - 보급로
public class SWEA_1249 {
    static int N, min;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Position {
        int row, col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            bfs(0, 0);
            System.out.printf("#%d %d\n", tc, min);
        }
    }

    private static void bfs(int row, int col) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(row, col));

        int[][] minArr = new int[N][N]; // 도착지까지의 최소값을 담을 배열
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                minArr[i][j] = Integer.MAX_VALUE;
            }
        }

        minArr[0][0] = map[0][0];   // 시작점에 0저장

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(--size >= 0) {
                Position cur = queue.poll();
                int curRow = cur.row;
                int curCol = cur.col;
                for(int i = 0; i < dx.length; i++) {
                    int nr = curRow + dx[i];
                    int nc = curCol + dy[i];
                    if(isIn(nr, nc)) {
                        // num = 현재까지의 최소값에 다음 위치의 복구 시간 더하기
                        int num = minArr[curRow][curCol] + map[nr][nc];
                        if(minArr[nr][nc] > num) {  // 기존 값보다 현재 값이 더 작다면
                            queue.offer(new Position(nr, nc));
                            minArr[nr][nc] = num;
                        }

                    }
                }
            }
        }
        min = minArr[N - 1][N - 1]; // bfs를 모두 수행하면 우하단의 값이 최소값
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    }
}
