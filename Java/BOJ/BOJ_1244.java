import java.util.Scanner;

// BOJ_1244
public class BOJ_1244 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int switchNum = scan.nextInt();
        int[] arr = new int[switchNum + 1];
        for (int i = 1; i <= switchNum; i++) {
            arr[i] = scan.nextInt();
        }

        int studentNum = scan.nextInt();
        for (int tc = 0; tc < studentNum; tc++) {
            int sex = scan.nextInt();
            int num = scan.nextInt();
            if (sex == 1) {
                for (int i = num; i <= switchNum; i += num) {
                    arr[i] ^= 1;
                }
            } else if (sex == 2) {
                arr[num] ^= 1;
                for (int i = 1; i < switchNum; i++) {
                    if (num - i > 0 && num + i <= switchNum && arr[num - i] == arr[num + i]) {
                        arr[num - i] ^= 1;
                        arr[num + i] ^= 1;
                    } else
                        break;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if(i % 20 == 0)
                System.out.println();
        }
    }
}