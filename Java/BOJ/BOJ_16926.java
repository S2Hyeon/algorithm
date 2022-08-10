import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_16926 배열돌리기 1
public class BOJ_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int inputRow = Integer.parseInt(st.nextToken());
        int inputCol = Integer.parseInt(st.nextToken());
        int rotate = Integer.parseInt(st.nextToken());  // 회전 수
        int depth = Math.min(inputRow, inputCol) / 2;   // 회전시킬 수 있는 배열 개수

        int[][] arr = new int[inputRow][inputCol];
        int[] dx = {0, 1, 0, -1};   // 우 하 좌 상
        int[] dy = {1, 0, -1, 0};

        for(int i = 0 ; i < inputRow; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < inputCol; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < rotate; r++) {
            for(int d = 0; d < depth; d++) {
                int endRow = inputRow - d - 1;  // 현재 depth에서 행의 끝
                int endCol = inputCol - d - 1;  // 현재 depth에서 열의 끝
                int temp = arr[d][d];   // 처음 숫자를 임시로 보관
                int dir = 0;    // 움직이는 방향

                for(int i = d; i < endCol; i++) {   // 현재 depth의 첫번째 열부터 끝까지
                    int nextCol = i + dy[dir];  // 오른쪽으로 이동
                    arr[d][i] = arr[d][nextCol];    // 행은 고정
                }
                dir++;

                for(int i = d; i < endRow; i++) {   // 현재 depth의 첫번째 행부터 끝까지
                    int nextRow = i + dx[dir];  // 아래쪽으로 이동
                    arr[i][endCol] = arr[nextRow][endCol];  // 열은 고정
                }
                dir++;

                for(int i = endCol; i > d; i--) {   // 현재 depth의 열의 끝에서 depth의 첫번째 열까지
                    int nextCol = i + dy[dir];  // 왼쪽으로 이동
                    arr[endRow][i] = arr[endRow][nextCol];  // 행은 고정
                }
                dir++;

                for(int i = endRow; i > d; i--) {   // 현재 depth의 행의 끝에서 depth의 첫번째 행까지
                    int nextRow = i + dx[dir];  // 위쪽으로 이동
                    arr[i][d] = arr[nextRow][d];  // 열은 고정
                }

                arr[d + 1][d] = temp;   // 임시로 저장해두었던 값 마지막으로 처리
            }
        }
        for(int i = 0; i < inputRow; i++) {
            for(int j = 0; j < inputCol; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
