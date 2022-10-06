import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_9205 맥주 마시면서 걸어가기
public class BOJ_9205 {

    static class Position {
        int row, col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static LinkedList<Integer>[] adjList;
    static LinkedList<Position> pointList;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine()) + 2;
            adjList = new LinkedList[n];
            pointList = new LinkedList<>();
            visited = new boolean[n];

            for(int i = 0; i < n; i++) {    // 인접리스트 초기화
                adjList[i] = new LinkedList<>();
            }

            StringTokenizer st;
            for(int i = 0; i < n; i++) {    // 정점 리스트 생성
                st = new StringTokenizer(br.readLine());
                pointList.add(new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }

            for(int i = 0, iEnd = pointList.size() - 1; i < iEnd; i++) {    // 첫번째 정점부터 n - 1 정점까지
                Position from = pointList.get(i);
                for(int j = i + 1, jEnd = pointList.size(); j < jEnd; j++) {    // 다음 정점부터 n - 1 정점까지
                    Position to = pointList.get(j);
                    int distance = Math.abs(from.row - to.row) + Math.abs(from.col - to.col);
                    // 편의점에 들리지 않고 이동할 수 있는 최대 거리 : 20 * 50 = 1000
                    if(distance <= 1000) {  // 거리가 1000 이하인 경우에만 간선 생성
                        adjList[i].add(j);
                        adjList[j].add(i);
                    }
                }
            }
            bfs();
            if(visited[n - 1]) {
                System.out.println("happy");
            }
            else {
                System.out.println("sad");
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(0);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i = 0, end = adjList[cur].size(); i < end; i++) {
                int ad = adjList[cur].get(i);
                if(visited[ad]) continue;

                visited[ad] = true;
                queue.offer(ad);
            }
        }
    }
}
