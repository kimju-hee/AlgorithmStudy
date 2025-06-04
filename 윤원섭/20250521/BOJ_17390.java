import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        long[] Sum = new long[N];
        Sum[0] = (long) A[0];
        for (int i = 1; i < N; i++) {
            Sum[i] = Sum[i-1] + A[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long result;
            if (L==1) {
                result = Sum[R-1];
            } else {
                result = Sum[R-1] - Sum[L-2];
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
