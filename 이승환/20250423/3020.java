import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N은 동굴의 길이, N은 항상 짝수(석순과 종유석의 개수가 같음)
        int H = Integer.parseInt(st.nextToken()); // H는 높이

        int[] stalagmites = new int[N/2];// 석순
        int[] stalactites = new int[N/2];// 종유석
        // int[] count = new int[H]; // 부숴야하는 개수
        int total=0,count=0;
        int min = Integer.MAX_VALUE; //부숴야하는 개수의 최솟값
        

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            if (i%2==0) stalagmites[i/2]=Integer.parseInt(st.nextToken()); // 번갈아 가면서 입력받기
            else stalactites[(i-1)/2] = Integer.parseInt(st.nextToken());
        }

        // 종유석과 석순 배열을 입력받은 뒤, 개수를 셀 때, 정렬을 한 다음에 lowerBound
        Arrays.sort(stalactites);
        Arrays.sort(stalagmites);
        
        for(int i=0;i<H;i++){
            int countStalagmites = N/2 - lowerBound(stalagmites, H-i); // 석순 배열의 길이에서 i의 인덱스값을 빼면 부숴야하는 석순의 개수
            int countStatlactites = N/2 -lowerBound(stalactites, i+1); // 종유석 배열의 길이에서 i+1의 인덱스 값을 빼면 부숴야하는 종유석의 개수
            total = countStalagmites + countStatlactites; //부숴야하는 개수의 총합
            if(total<min){//부숴야하는 최솟값 업데이트
                min= total; 
                count=1;
            }else if (total==min){//부숴야하는 개수가 같을 때
                count++; //개수 카운팅
            }
        }
        System.out.println(min + " " + count); 
        
    }

    public static int lowerBound(int[] arr, int target){//가장 먼저 등장하는 target보다 크거나 같은 값의 인덱스를 리턴
        int left=0, right=arr.length;
        while(left<right){
            int mid =(left + right)/2;
            if(arr[mid]<target) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}