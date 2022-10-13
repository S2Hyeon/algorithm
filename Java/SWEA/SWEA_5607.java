import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA_5607 [Professional] 조합
public class SWEA_5607 {
    static final long MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long[] fac = new long[N + 1];
            fac[0] = 1;
            for(int i = 1; i <= N; i++) {   // !들을 미리 계산
                fac[i] = (fac[i - 1] * i) % MOD;
            }
            long numerator = fac[N] % MOD;  // 분자 n!
            long denominator = pow((fac[R] * fac[N - R]) % MOD, MOD - 2);   // 분모 r!(n - r!)^MOD - 2 계산
            long result = (numerator * denominator) % MOD;  // n! * (r!(n - r!)^MOD - 2
            System.out.printf("#%d %d\n", tc, result);
        }
    }
    public static long pow(long a, long p){
        // 연산중에 숫자가 너무 커지고, 속도가 느려지므로
        // 분할 정복 방식을 사용하면서 MOD로 나머지연산을 반복한다.
        if(p == 0)      // 지수가 0이면
            return 1;   // 1리턴
        long ans = pow(a,p / 2);
        long next = (ans * ans) % MOD;
        if(p % 2 == 0)                  // 짝수일 때 a^p = a^p/2 * a^p/2 이므로
            return next;                // 그대로
        else                            // 홀수 일 때 next^p = a^(p - 1)/2 * a^(p - 1)/2 * a 이므로
            return (next * a) % MOD;    // * a를 추가
    }
}
