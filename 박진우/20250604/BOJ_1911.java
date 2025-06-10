import java.io.*;
import java.util.*;

public class BOJ_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] pools = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pools[i][0] = Integer.parseInt(st.nextToken());
            pools[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pools, (a, b) -> a[0] - b[0]);

        int answer = 0;
        int last = 0; // 마지막으로 덮은 위치

        for (int[] pool : pools) {
            int start = pool[0];
            int end = pool[1];

            if (start > last) last = start;

            int need = (int) Math.ceil((double)(end - last) / L);
            answer += need;
            last += need * L;
        }

        System.out.println(answer);
    }
}
