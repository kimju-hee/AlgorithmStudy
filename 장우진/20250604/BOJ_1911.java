import java.io.;
import java.util.;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] w = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i][0] = Integer.parseInt(st.nextToken());
            w[i][1] = Integer.parseInt(st.nextToken());
        }

        // 웅덩이를 시작 지점 기준으로 오름차순 정렬
        Arrays.sort(w, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        int last = 0;    // 널빤지로 덮은 마지막 위치

        for (int i = 0; i < N; i++) {
            int start = Math.max(w[i][0], last);// 웅덩이 시작지점과 덮인 지점을 비교
            int end = w[i][1];
            if (start >= end) continue; // 덮인 지점이 끝보다 크면 넘어감

            int length = end - start;

            int boards = length / L;
            if (length % L != 0) boards++; // 널빤지수 계산(올림처리)
            count += boards;

            last = start + boards * L; // 널빤지를 덮은 위치 갱신
        }
        System.out.println(count);
    }
}