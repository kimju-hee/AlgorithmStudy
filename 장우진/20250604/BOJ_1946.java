import java.io.;
import java.util.;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] p = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                p[i][0] = Integer.parseInt(st.nextToken()); // 서류 순위
                p[i][1] = Integer.parseInt(st.nextToken()); // 면접 순위
            }

            // 서류 순위 기준 정렬(2차원 배열 정렬)
            Arrays.sort(p, Comparator.comparingInt(a -> a[0]));

            int count = 1;
            int best = p[0][1];

            for (int i = 1; i < N; i++) {
                if (p[i][1] < best) { //면접 순위를 비교해서 기준 등수보다 높으면 뽑고 기준 갱신
                    count++;
                    best = p[i][1];
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}