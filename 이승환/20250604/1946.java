import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            // score배열의 0번 째 인덱스는 서류점수, 1번 째 인덱스는 면접점수
            int scores[][] = new int[N][2];
            for (int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[j][0] = Integer.parseInt(st.nextToken());
                scores[j][1] = Integer.parseInt(st.nextToken());
            }  
            //서류성적순위를 기준으로 오름차순 정렬
            Arrays.sort(scores, (o1, o2) -> o1[0] - o2[0]);
            
            int maxRank = scores[0][1];
            int count = 1;
            //동석차가 없으므로 서류성적순위 비교는 필요없음
            //j번째 지원자의 면접성적순위가 현재 채용된 사람 중, 가장 높은 성적을 가진 사람보다 높다면 채용
            for (int j = 1; j < N; j++){
                if (scores[j][1] < maxRank) {
                    maxRank = scores[j][1];
                    count++;
                }
                if (maxRank == 1) break;
            }
            System.out.println(count);
        }
    }
}