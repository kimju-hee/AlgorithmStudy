import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] list = new int[N];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            list[i] = temp;
        }

        Arrays.sort(list);

        st = new StringTokenizer(bufferedReader.readLine());
        int target = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = N-1;
        int count = 0;
        while (start < end) {
            if (list[start] + list[end] == target) {
                count ++;
            }
            if (list[start] + list[end] <= target) {
                start ++;
            } else {
                end —;
            }
        }
        System.out.println(count);
    }
}
