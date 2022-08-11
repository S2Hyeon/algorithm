import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ_3040 백설 공주와 일곱 난쟁이
public class BOJ_3040 {
    static int N, R;
    static int[] numbers, inputs;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 9;  // 9명중
        R = 7;  // 7명 뽑기 9C7
        numbers = new int[R];   // 조합 담을 배열
        inputs = new int[N];    // 입력 담을 배열

        for(int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        comb(N, R);
    }

    private static void comb(int cnt, int r) {
        if(r == 0) {    // 배열의 끝부터 시작하므로 r이 0이면 조합 완성된 것
            int sum = 0;
            for(int i = 0; i < R; i++) {    // 조합 완성되면 조합 내 원소 합산
                sum += numbers[i];
            }
            if(sum == 100) {    // 합이 100이면 출력
                for(int i = 0; i < R; i++) {
                    System.out.println(numbers[i]);
                }
            }
            return;
        }

        if(cnt < r) return; // 뽑아야 하는 개수(r)가 남았는데 원소(cnt)를 이미 다 돌아버렸을 때

        numbers[r - 1] = inputs[cnt - 1];   // 배열의 끝부터 원소를 채워나감
        comb(cnt - 1, r - 1);   // 원소를 선택한 경우
        comb(cnt - 1, r);       // 원소를 선택하지 않은 경우
    }
}
