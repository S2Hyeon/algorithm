import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_2636 치즈
public class BOJ_2636 {
    static int N, M, cnt, time;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static Queue<Position> cQueue;

    static class Position {
        int row, col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        // 테두리부터 치즈가 없는 부분(흰색)을 bfs로 탐색해서
        // 탐색중에 만나는 치즈 부분이 다음에 없어질 치즈의 테두리 => 큐에 저장
        //     근데 시간효율성을 위해 반복할때마다 흰색 부분의 탐색 시작 위치를
        //    없어질 치즈의 테두리 중 가장 위쪽에 있는 곳의 1열부터 하면 좋을 것 같다.
        // 큐에서 poll 하면서 해당 위치를 흰색(0)으로 표시

        // 치즈의 크기를 입력받으면서 저장(1의 개수 세기)
        // 테두리에서 지울때마다 지운 개수 만큼 저장되어있던 치즈크기 빼고
        // 만약 뺀 결과가 0 이라면 마지막 남은 개수 복원해서 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cQueue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(n == 1) {    // 치즈의 크기 계산
                    cnt++;
                }
            }
        }

        while(cnt >= 0) {   // 치즈가 모두 없어질 때까지
            visited = new boolean[N][M];    // 방문표시 배열 초기화
            bfs();
            time++; // 시간 증가
            if(cnt == cQueue.size())    // 남아있는 치즈의 크기가 없어질 치즈의 크기와 같다면
                break;
            while(!cQueue.isEmpty()) {  // 치즈의 테두리 없애기
                Position p = cQueue.poll();
                map[p.row][p.col] = 0;
                cnt--;  // 치즈 크기 감소
            }
        }

        System.out.println(time);
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Position curPos = queue.poll();
            int curRow = curPos.row;
            int curCol = curPos.col;
            for(int i = 0; i < dx.length; i++) {
                int nr = curRow + dx[i];
                int nc = curCol + dy[i];
                if(isIn(nr,nc) && !visited[nr][nc]) {
                    if(map[nr][nc] == 0) {  // 치즈가 아니라면 다음위치 큐에 넣기
                        queue.offer(new Position(nr, nc));
                    }
                    else {  // 치즈의 테두리면 없어질 치즈이므로 큐에 넣기
                        cQueue.offer(new Position(nr, nc));
                    }
                    visited[nr][nc] = true; // 방문 표시
                }
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}
