import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  

        int n = sc.nextInt();
        int[] arr = new int[n];

        // 배열에 정수 n개를 입력받아 저장
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // i번째 위치에 사용자로부터 입력 받은 값 저장
        }

        // 두 수의 합으로 찾고 싶은 값 x 입력
        int x = sc.nextInt();

        // 더 이상 입력 받을 일이 없으므로 Scanner 종료 (자원 누수 방지)
        sc.close(); 

        // 오름차순 정렬
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int cnt = 0;

        // left와 right가 겹치지 않을 때까지 반복
        while (left < right) {
            int sum = arr[left] + arr[right];

            // 두 수의 합이 x와 같은 경우
            if (sum == x) {
                cnt++;
                left++;
                right--;
            } 
            // 두 수의 합이 x보다 작은 경우
            else if (sum < x) {
                left++;
            } 
            // 두 수의 합이 x보다 큰 경우
            else {
                right--;
            }
        }
        System.out.println(cnt);
    }
}
