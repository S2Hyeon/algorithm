import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ_2239 스도쿠
public class BOJ_2239 {
    static int[][] board;
    static ArrayList<Position> zeroPosList;
    static int N, zeroCnt;
    static boolean findAnswer;
    static StringBuilder sb;
    static class Position {
        int row, col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 9;
        board = new int[N][N];
        zeroPosList = new ArrayList<>();
        sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                int n = str.charAt(j) - '0';
                board[i][j] = n;
                if(n == 0) {    // 0이 있다면 해당 위치를 리스트에 저장
                    zeroPosList.add(new Position(i, j));
                }
            }
        }

        zeroCnt = zeroPosList.size();   // 채워야 하는 0의 개수
        perm(0);

        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if(findAnswer) return;  // 답을 이미 찾았다면 리턴

        if(cnt == zeroCnt) {    // 0을 모두 채웠다면
            findAnswer = true;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            return;
        }

        Position curPos = zeroPosList.get(cnt); // 현재 위치 가져오기
        int curRow = curPos.row;
        int curCol = curPos.col;

        for(int i = 1; i <= N; i++) {
            // 가로, 세로, 3 x 3에 겹치는게 없다면
            if(check(curRow, curCol, i)) {
                board[curRow][curCol] = i;
                perm(cnt + 1);
                board[curRow][curCol] = 0;
            }
        }
    }

    private static boolean check(int curRow, int curCol, int num) {
        // 가로 검사
        for(int i = 0; i < N; i++) {
            if(board[curRow][i] == num) {   // 넣으려는 숫자가 이미 있다면
                return false;
            }
        }

        // 세로 검사
        for(int i = 0; i < N; i++) {
            if(board[i][curCol] == num) {
                return false;
            }
        }

        // 3 x 3 검사
        int startRow = curRow / 3 * 3;  // 3 x 3 블럭의 시작 행
        int startCol = curCol / 3 * 3;  // 3 x 3 블럭의 시작 열
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
