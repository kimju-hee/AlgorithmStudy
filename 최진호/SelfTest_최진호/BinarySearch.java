package SelfTest_최진호;
import java.util.*;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        sc.nextLine(); //java는 버퍼를 비워줘야 한다.

        String[] inputs = sc.nextLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(String s : inputs){
            arr.add(Integer.parseInt(s,find));
        }
        Collections.sort(arr); // ArrayList는 Arrays.sort() 대신 Collections.sort() 사용

        int n = countBinarySearch(arr,find);
        System.out.println(n);
        sc.close();
    }
    public static int countBinarySearch(ArrayList<Integer> arr, int find){
        int count = 0;
        int left = 0;
        int right = arr.size()-1;
        boolean check = false;
        while(left<=right){
            count++;
            int mid = (left+right)/2;
            if(arr.get(mid)==find){
                check = true;
                break;
            }else if(arr.get(mid)<find){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return check ? count : -1;
    }
}
