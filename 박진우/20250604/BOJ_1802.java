//BOJ_1802 종이 접기
//https://www.acmicpc.net/problem/1802

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t;i++){
            String sc = br.readLine();
            boolean poss = true;
            int length=sc.length();

            while (length>1){
                int min = length/2;
                for(int j=0;j<min;j++){
                    if (sc.charAt(j)==sc.charAt(length-1-j)){
                        poss=false;
                        break;
                    }
                }
                if(!poss)break;
                length = min;
            }
            System.out.println(poss ? "YES":"NO");
        }
    }
}
