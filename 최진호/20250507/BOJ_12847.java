import java.util.*;

public class BOJ_12847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputNM = sc.nextLine().split(" ");
        int n = Integer.parseInt(inputNM[0]);
        int m = Integer.parseInt(inputNM[1]);
        String[] inputs = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }
        //----------------------------------------여기까지 입력
        long sum_window=0;

        for(int i=0;i<m;i++){
            sum_window += arr[i];
        }
        long result = sum_window;
        for (int i = m; i < n; i++) {
            sum_window = sum_window - arr[i - m] + arr[i];
            if(sum_window > result){
                result = sum_window;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
