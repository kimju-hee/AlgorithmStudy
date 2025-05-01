import java.io.*;
import java.util.*;

public class Main {
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스마다 반복
        for (int t = 0; t < T; t++) {
            // 한 줄 입력받아 N과 M 분리
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // A 동물 수
            int M = Integer.parseInt(st.nextToken()); // B 동물 수

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
          
            Arrays.sort(A);
            Arrays.sort(B);

            // 총 가능한 쌍의 개수
            int count = 0;
            // A의 각 동물 무게마다
            for (int i = 0; i < N; i++) {
                // B에서 A[i]보다 작은 B의 수를 찾는다
                count += lowerBound(B, A[i]);
            }
            System.out.println(count);
        }
    }
    static int lowerBound(int[] arr, int X) {
        int left = 0, right = arr.length - 1;
        int res = 0; // 결과: X보다 작은 원소 개수

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < X) {
                res = mid + 1;
                left = mid + 1; // 더 오른쪽에도 작은 값이 있는지 탐색
            } else {
                // mid번째 값이 X 이상이면 더 왼쪽 탐색
                right = mid - 1;
            }
        }
        return res;
    }
}
