import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(input[0]); // 서류
                arr[i][1] = Integer.parseInt(input[1]); // 면접
            }
            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
            int count = 1;
            int interview = arr[0][1];

            for (int i = 1; i < N; i++) {
                if (arr[i][1] < interview) {
                    count++;
                    interview = arr[i][1];
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
