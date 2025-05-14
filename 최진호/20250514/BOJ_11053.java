import java.util.*;

public class BOJ_11053 {
    public static void main(String[] args) {
        // Bottom Up 방식!
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i< n;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        //------------------------------------------------

        //저장된 번호보다 크다면 count ++, lastnum 저장
        int[] result = new int[n];
        Arrays.fill(result, 1); // 모든 원소의 최소 LIS 길이는 1

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }
        int maxNumber = 0;
        for(int i : result){
            if(maxNumber < i){
                maxNumber = i;
            }
        }
        System.out.println(maxNumber);
    }
}
