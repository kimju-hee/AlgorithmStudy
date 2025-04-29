import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] A = new int[a];
            int[] B = new int[b];

            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < a; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < b; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            int result = 0;
            for (int j = 0; j < a; j++) {
                result += binarySearch(B, A[j]);
            }
            System.out.println(result);
        }

    }

    public static int binarySearch(int[] list, int now) {
        int left = 0;
        int right = list.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list[mid] < now) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return count;
    }

}
