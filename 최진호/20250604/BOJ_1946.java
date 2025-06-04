import java.io.*;
import java.util.*;

public class BOJ_1946 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(input[0]);
                arr[j][1] = Integer.parseInt(input[1]);
            }
            Arrays.sort(arr, Comparator.comparingInt(a->a[0]));

            int result = 1;
            int minvalue = arr[0][1];
            for (int j = 0; j < n; j++) {
                if(minvalue > arr[j][1]){
                    result++;
                    minvalue = arr[j][1];
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
