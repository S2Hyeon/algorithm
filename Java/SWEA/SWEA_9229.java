import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA_9229 한빈이와 Spot Mart
public class SWEA_9229 {
    static int N, R, weightLimit, maxWeight;
    static int[] numbers, inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = 2;
            maxWeight = 0;
            weightLimit = Integer.parseInt(st.nextToken());
            numbers = new int[R];
            inputs = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }

            comb(N, R);
            if(maxWeight == 0)
                maxWeight = -1;
            System.out.printf("#%d %d\n", tc, maxWeight);

        }

    }

    private static void comb(int cnt, int r) {
        if(r == 0) {
            int sum = 0;
            for(int i = 0; i < R; i++) {
                sum += numbers[i];
            }
            if(weightLimit >= sum && maxWeight < sum)
                maxWeight = sum;
            return;
        }

        if(cnt < r) return;

        numbers[r - 1] = inputs[cnt - 1];
        comb(cnt - 1, r - 1);
        comb(cnt - 1, r);
    }
}
