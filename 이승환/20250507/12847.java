import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
	
        Queue<Integer> pay = new LinkedList<>();
        long max = -1;
        long sum = 0;
	
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());

            pay.offer(num);
            sum += num;
            
            if (pay.size() > m){
                sum -= pay.poll();
            }
            max = (max < sum) ? sum : max;

        }
        System.out.println(max);        

    }
}