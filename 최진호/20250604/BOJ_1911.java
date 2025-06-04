import java.io.*;
import java.util.*;

public class BOJ_1911 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int result = 0;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(arr, Comparator.comparingInt(a->a[0]));

        int isCovered = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i][0] < isCovered){ //이미 덮혀있는 구간
                arr[i][0] = isCovered;
            }
            if(arr[i][0] >= arr[i][1]){continue;}//오버해서 덮힌경우
            int needPlate = (arr[i][1] - arr[i][0] + l - 1) / l;//올림 계산
            result+=needPlate;
            isCovered = arr[i][0] + (l*needPlate);
        }
        
        sb.append(result).append("\n");
        System.out.println(sb);
    }
}
