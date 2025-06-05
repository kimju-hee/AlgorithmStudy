// 이 방식이 왜 틀렸는지 모르겠음 ㅡㅡㅡ
import java.io.*;
import java.util.*;

public class BOJ_1082_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String inputs = br.readLine();
            int len = inputs.length();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = Integer.parseInt(String.valueOf(inputs.charAt(j)));
            }
            boolean isSame = true;
            for (int j = 0; j < (len-1)/2; j++) {
                if(arr[j] == arr[len-1-j]){
                    isSame = false;
                    break;
                }else{
                    continue;
                }
            }
            if(isSame){sb.append("YES").append("\n");}
            else{sb.append("NO").append("\n");}
        }
        System.out.println(sb);
    }
}