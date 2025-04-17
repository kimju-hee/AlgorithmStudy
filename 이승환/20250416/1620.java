import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> pokedex1 = new HashMap<Integer, String>();
        HashMap<String, Integer> pokedex2 = new HashMap<String, Integer>();
        
        for(int i=1;i<=N;i++){
            String name = br.readLine();
            pokedex1.put(i,name);
            pokedex2.put(name,i);
        }
        for(int i=0;i<M;i++){
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))){//첫번째 문자가 숫자면 숫자,문자 판별가능
                int num = Integer.parseInt(str);
                sb.append(pokedex1.get(num) + "\n");
            } else sb.append(pokedex2.get(str) + "\n");
        }
        System.out.print(sb);
    }
}