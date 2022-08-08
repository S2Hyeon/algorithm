import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    // BOJ_2493 탑
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek()[1] > arr[i]) {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                else {
                    stack.pop();
                }
            }
            if(stack.isEmpty())
                sb.append(0).append(" ");
            int[] stackData = {i + 1, arr[i]};
            stack.push(stackData);
        }
        System.out.println(sb);
    }
}
