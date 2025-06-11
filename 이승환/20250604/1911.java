package BOJSOLVE.src;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double L = Integer.parseInt(st.nextToken());

        //물 웅덩이
        int[][] puddles = new int[N][2];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            puddles[i][0] = Integer.parseInt(st.nextToken());
            puddles[i][1] = Integer.parseInt(st.nextToken());
        }
        //물 웅덩이의 시작 위치를 기준으로 오름차순 정렬
        Arrays.sort(puddles,(o1, o2) -> o1[0] - o2[0]);

        //판자의 총 개수 
        int count = 0;
        
        //가장 최근에 놓은 판자의 오른쪽 끝 위치
        int prevBoardEnd = 0;
        int quo = 0;
        for (int i = 0; i < N; i++){
            int puddleStart = puddles[i][0];
            int puddleEnd = puddles[i][1];

            //판자의 오른쪽 부분이 오른쪽의 웅덩이를 덮지 않았을 때
            if (prevBoardEnd < puddleStart) {
                quo = (int)Math.ceil((double)(puddleEnd - puddleStart) / L);
                prevBoardEnd = puddleStart + quo * (int)L;
            } else {//판자의 오른쪽 부분이 오른쪽의 웅덩이를 덮었을 때
                quo = (int)Math.ceil((double)(puddleEnd - prevBoardEnd) / L);
                
                prevBoardEnd = prevBoardEnd + quo * (int)L;
            }
        count += quo;
        }   
        System.out.println(count);
    }
}