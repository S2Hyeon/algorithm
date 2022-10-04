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
                if(n == 0) {
                    zeroPosList.add(new Position(i, j));
                }
            }
        }

        zeroCnt = zeroPosList.size();
        perm(0);

        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if(findAnswer) return;

        if(cnt == zeroCnt) {
            findAnswer = true;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            return;
        }

        Position curPos = zeroPosList.get(cnt);
        int curRow = curPos.row;
        int curCol = curPos.col;

        for(int i = 1; i <= N; i++) {
            if(check(curRow, curCol, i)) {
                board[curRow][curCol] = i;
                perm(cnt + 1);
                board[curRow][curCol] = 0;
            }
        }
    }

    private static boolean check(int curRow, int curCol, int num) {
        for(int i = 0; i < N; i++) {
            if(board[curRow][i] == num) {
                return false;
            }
        }

        for(int i = 0; i < N; i++) {
            if(board[i][curCol] == num) {
                return false;
            }
        }

        int startRow = curRow / 3 * 3;
        int startCol = curCol / 3 * 3;
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
