import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int q = Integer.parseInt(st.nextToken());
            int cnt = countMap.getOrDefault(q, 0);
            sb.append(cnt).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}