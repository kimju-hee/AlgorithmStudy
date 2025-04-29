import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int sum=0;

            int[] As = new int[N];
            int[] Bs = new int[M];

            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) As[j] = Integer.parseInt(st.nextToken());

            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) Bs[j] = Integer.parseInt(st.nextToken());

            //B를 정렬한 다음, A의 값이 B의 어디에 있는지 
            //lowerBound로 확인하면 lowerBound의 값이 A의 크기가 B보다 큰 쌍의 개수.
            Arrays.sort(Bs); // B정렬 
            for(int j=0;j<N;j++){
                int result = lowerBound(Bs,As[j]); // B에서 A의 위치를 확인하면 A의 인덱스가 A보다 작은 B의 개수.
                sum+=result;
            }
            sb.append(sum +"\n");
        }
        System.out.print(sb);
    }
    public static int lowerBound(int[] arr, int target){ //lowerBound메서드는 target보다 크거나 같은 값이 처음 나오는 인덱스를 리턴
        int left=0,right=arr.length;

        while(left<right){
            int mid = (left + right)/2;
            if (arr[mid]<target) left=mid + 1;
            else right=mid;
        }
        return right;
    }
}
