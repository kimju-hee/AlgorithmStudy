import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12847 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());

        long[] list = new long[N];
        for (int i = 0; i < N; i++) {
            list[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < M; i++) {
            sum += list[i];
        }

        long max = sum;

        for (int i = M; i < N; i++) {
            sum = sum - list[i - M] + list[i];
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
