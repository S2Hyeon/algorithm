import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_15961 회전 초밥
public class BOJ_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 접시 수
        int d = Integer.parseInt(st.nextToken());   // 초밥의 가짓 수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호
        int cnt = 0;
        int max;

        int[] arr = new int[N]; // 전체 초밥접시 배열
        int[] selected = new int[d + 1];    // 중복검사 배열

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 미리 k개의 초밥을 중복되지 않게 윈도우에 넣는다
        for(int i = 0; i < k; i++) {
            if(selected[arr[i]] == 0) { // 한번도 먹은적이 없는 초밥이라면
                cnt++;
            }
            selected[arr[i]]++; // 먹은 초밥 번호 표시
        }

        // 미리 넣었을 때를 최대값의 초기값으로
        max = cnt;

        for(int i = 1; i < N; i++) {
            if(max <= cnt) {    // 최대값이 갱신되어야 하고
                if(selected[c] == 0) {  // 쿠폰 초밥을 먹지 않았다면
                    max = cnt + 1;  // 쿠폰 초밥 포함시키기
                }
                else {  // 쿠폰초밥이 이미 포함되어 있다면 그대로
                    max = cnt;
                }
            }

            selected[arr[i - 1]]--; // 윈도우에서 앞쪽 초밥 빼기
            if(selected[arr[i - 1]] == 0) { // 앞쪽 초밥을 뺐을 때 윈도우 내에 같은 초밥이 없다면
                cnt--;
            }

            // 회전초밥이기 때문에 나머지 연산으로 배열의 마지막 인덱스에서 맨앞으로 돌아가게 한다.
            int n = (i + k - 1) % N;
            if(selected[arr[n]] == 0) { // 윈도우에 추가할 뒤쪽 초밥이 윈도우 내에 없다면
                cnt++;
            }
            selected[arr[n]]++; // 윈도우에 뒤쪽 초밥을 추가
        }
        System.out.println(max);
    }
}
