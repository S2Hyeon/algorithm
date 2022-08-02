import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[] dir = {0, 1, 2, 3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n;
        int[][] map;
        int x, y, index;
        for(int tc = 1; tc <= T; tc++) {
            x = 0;
            y = 0;
            index = 0;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int i = 0; i < n * n; i++) {
                map[x][y] = i + 1;
                x += dr[dir[index]];
                y += dc[dir[index]];
                if(x < 0 || y < 0 || x >= n || y >= n || map[x][y] != 0) {
                    x -= dr[dir[index]];
                    y -= dc[dir[index]];
                    index = (index + 1) % 4;
                    x += dr[dir[index]];
                    y += dc[dir[index]];
                }
            }
            System.out.println("#" + tc);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
