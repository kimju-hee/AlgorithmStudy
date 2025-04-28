package SelfTest_최진호;
import java.util.*;

public class _FreeSelfTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(String s:input){
            arr.add(Integer.parseInt(s));
        }
        System.out.println(sum_(arr));
    }
    public static int sum_(ArrayList<Integer> arr){
        if(arr.size()==1){
            return arr.get(0);
        }else{
            ArrayList<Integer> temp_arr = new ArrayList<>();
            for(int i=1;i<arr.size();i++){
                temp_arr.add(arr.get(i));
            }
            return arr.get(0) + sum_(temp_arr);
        }        
    }
}
