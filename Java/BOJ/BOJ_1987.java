import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1987 알파벳
public class BOJ_1987 {

    static int R, C, result;
    static boolean[] visited;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C + 1];
        visited = new boolean[26];  // 알파벳 방문 여부 배열
        result = 1;

        for(int i = 1; i <= R; i++) {
            String line = br.readLine();
            for(int j = 1; j <= C; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        dfs(1, 1, 1);
        System.out.println(result);
    }

    private static void dfs(int row, int col, int cnt) {
        visited[map[row][col] - 'A'] = true;    // 현재 위치에 있는 알파벳의 방문 표시

        for(int i = 0; i < dx.length; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if(nextRow > 0 && nextRow <= R && nextCol > 0 && nextCol <= C) {
                if(!visited[map[nextRow][nextCol] - 'A']) { // 방문하지 않았던 알파벳이라면
                    dfs(nextRow, nextCol, cnt + 1); // 해당 위치로 이동
                    visited[map[nextRow][nextCol] - 'A'] = false;   // 다른 길을 찾기위해 방문했던 알파벳 방문표시 해제
                }
            }
        }
        result = Math.max(result, cnt); // 더이상 갈 곳이 없을 때 현재 카운트 값과 기존값을 비교하여 갱신
    }
}
