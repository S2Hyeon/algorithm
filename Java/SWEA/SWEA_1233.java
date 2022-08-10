import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA_1233 사칙연산 유효성 검사
public class SWEA_1233 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringTokenizer st;
        for(int tc = 1; tc <= T; tc++) {
            int flag = 1;	// 연산이 가능한지 여부
            int nodeNum = Integer.parseInt(br.readLine());
            for(int i = 0; i < nodeNum; i++) {
                st = new StringTokenizer(br.readLine());
                int tokenNum = st.countTokens();
                st.nextToken();
                char c = st.nextToken().charAt(0);
                if(tokenNum == 4) {	// 토큰 개수가 4개이면 자식이 있는 노드
                    if(c >= '0' && c <= '9') {	// 노드의 값이 숫자이면 계산 불가
                        flag = 0;
                    }
                }
                else if(tokenNum == 2) { // 토큰 개수가 2개이면 리프노드
                    if(!(c >= '0' && c <= '9')) {	// 노드의값이 숫자가 아니면 계산 불가
                        flag = 0;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, flag);
        }
    }
}
