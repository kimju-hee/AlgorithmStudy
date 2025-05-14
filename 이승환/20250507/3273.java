import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int i = 0, j = n - 1, count = 0;

        while(i < j){
            int result = nums[i] + nums[j];

            if (result == x){
                count++;
                i++;
                j--;

            } else if (result < x){
                i++;

            } else {                j--;
            }
        }

        System.out.println(count);
    }
}