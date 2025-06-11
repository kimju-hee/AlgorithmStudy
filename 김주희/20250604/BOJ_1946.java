import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] list = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                list[j][0] = Integer.parseInt(st.nextToken());
                list[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(list, (a, b) -> a[0] - b[0]);

            int count = 1; // 첫 번째 사람은 항상 선발
            int minInterviewRank = list[0][1];

            for (int j = 1; j < N; j++) {
                if (list[j][1] < minInterviewRank) {
                    count++;
                    minInterviewRank = list[j][1];
                }
            }

            System.out.println(count);
        }
    }
}
