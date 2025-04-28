import java.io.*;
import java.util.*;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer,String> num2name = new HashMap<>();
        HashMap<String,Integer> name2num = new HashMap<>();

        for(int i =1;i<=n;i++){
            String name = br.readLine();
            num2name.put(i,name);
            name2num.put(name,i);
        }

        for(int i=0;i<m;i++){
            String input = br.readLine();
            if(name2num.containsKey(input)){
                System.out.println(name2num.get(input));
            }else{
                System.out.println(num2name.get(Integer.parseInt(input)));
            }
        }
    }
}
