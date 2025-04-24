import java.util.*;

public class BOJ_10816 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input_n = sc.nextLine().split(" ");
        int m = sc.nextInt();
        sc.nextLine();
        String[] input_m = sc.nextLine().split(" ");
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(input_n[i]);
        }
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(input_m[i]);
        }
        Arrays.sort(arr1);
        
        StringBuilder sb = new StringBuilder();
        for(int num : arr2){
            sb.append(bi_search_count(arr1, num)).append(" ");
        }

        System.out.println(sb);
    }
    public static int bi_search_count(int[] arr, int find){
        int left = 0;
        int right = arr.length;
        while(left<right){
            int mid = (left + right)/2;
            if(arr[mid]<find){left = mid+1;}
            else{right = mid;}
        }
        int left_idx = left;

        left = 0;
        right = arr.length;
        while(left<right){
            int mid = (left + right)/2;
            if(arr[mid]<=find){left = mid+1;}
            else{right = mid;}
        }
        int right_idx = left;
        
        return right_idx - left_idx ;
    }
}
