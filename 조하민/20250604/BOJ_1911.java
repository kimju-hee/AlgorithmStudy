package zaryogujo;
import java.util.*;

public class Puddle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 웅덩이 수
        int L = sc.nextInt(); // 널빤지 길이

        int[][] puddles = new int[N][2];
        for (int i = 0; i < N; i++) {
            puddles[i][0] = sc.nextInt(); // 시작점
            puddles[i][1] = sc.nextInt(); // 끝점
        }

        Arrays.sort(puddles, (a, b) -> a[0] - b[0]);

        int count = 0;
        int cover = 0; // 현재 널빤지로 덮은 범위의 끝

        for (int i = 0; i < N; i++) {
            int start = Math.max(puddles[i][0], cover);
            int end = puddles[i][1];

            if (start >= end) continue; 

            int length = end - start;
            int need = (length + L - 1) / L;

            count += need;
            cover = start + need * L;
        }

        System.out.println(count);
    }
}
