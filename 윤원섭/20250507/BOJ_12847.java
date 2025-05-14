import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n= 총 일수, m= 연속 근무일 수
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] arr = new long[n];

        // 일당 입력 받기
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // 첫 합 구하기
        long Sum = 0;
        for (int i = 0; i < m; i++) {
            Sum += arr[i];
        }

        long maxSum = Sum;

        // 슬라이딩 윈도우로 최대 금액 찾기
        for (int i = m; i < n; i++) {
            Sum = Sum + arr[i] - arr[i - m];
            if (Sum > maxSum) {
                maxSum = Sum;
            }
        }
        System.out.println(maxSum);
    }
}
