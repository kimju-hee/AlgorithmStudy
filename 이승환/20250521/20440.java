import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 모기 입퇴장 로그 초기화
        int[][] mosqitoes = new int[N][2];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            mosqitoes[i][0] = Integer.parseInt(st.nextToken());
            mosqitoes[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 모기의 입장시각을 기준으로 오름차순 정렬
        Arrays.sort(mosqitoes, (o1, o2) -> o1[0] - o2[0]);

        // 각 모기들의 퇴장시간을 저장하는 큐
        Queue<Integer> room = new PriorityQueue<>();

        //모기가 가장 많이 존재하는 시간대의 시작시각, 끝시각, 최대 모기 수
        int Te = 0;
        int Tx = 0;
        int max = 0;
        
        for(int i = 0; i < N; i++){
            
            // 모기가 입장하기 전에 퇴장해야하는 모기들을 퇴장시키기
            while (!room.isEmpty() && mosqitoes[i][0] > room.peek()){
                room.poll();
            }

            // 모기 입장
            room.offer(mosqitoes[i][1]);
            
            // 퇴장해야하는 모기의 퇴장시각이 현재 입장하는 모기의 입장시각과 같다면
            if (!room.isEmpty() && mosqitoes[i][0] == room.peek()) {
                
                //전부 퇴장
                while(!room.isEmpty() && mosqitoes[i][0] == room.peek()) {
                    room.poll();
                }
                // 모기의 수가 최대라면 끝시각 연장하기
                if (room.size() == max) Tx = room.peek();
                
            }

            // 마지막으로 결과값을 비교하여 업데이트
            if (room.size() > max) {
                max = room.size();
                Te = mosqitoes[i][0];
                Tx = room.peek();
            }
        }
        System.out.println(max);
        System.out.print(Te + " " + Tx);
    }
}
