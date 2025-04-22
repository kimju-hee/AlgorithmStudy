package SelfTest_최진호;
import java.util.*;

public class QuickSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(String s : input){
            arr.add(Integer.parseInt(s));
        }
        System.out.println(sort(arr));
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> arr){
        if(arr.size() <2){
            return arr;
        }
        int pivot = arr.get(0);
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for(int i = 1; i<arr.size(); i++){
            if(arr.get(i)<=pivot){
                less.add(arr.get(i));
            }else{
                greater.add(arr.get(i));
            }
        }
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.addAll(sort(less));
        sorted.add(pivot);
        sorted.addAll(sort(greater));

        return sorted;
    }
}

