import java.util.*;

public class BOJ_7795 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<t; i++){
            String[] input_size = sc.nextLine().split(" ");
            int size_a = Integer.parseInt(input_size[0]);
            int size_b = Integer.parseInt(input_size[1]);
            String[] input_a = sc.nextLine().split(" ");
            String[] input_b = sc.nextLine().split(" ");
            ArrayList<Integer> arr1 = new ArrayList<>(size_a);
            ArrayList<Integer> arr2 = new ArrayList<>(size_b);
            for(String s : input_a){arr1.add(Integer.parseInt(s));}
            for(String s : input_b){arr2.add(Integer.parseInt(s));}
            arr1 = quick_sort(arr1);
            arr2 = quick_sort(arr2);
            System.out.println(bi_search(arr1, arr2));
        }
    }
    public static int bi_search(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        int result = 0;
        int size_a = arr1.size();
        int size_b = arr2.size();
        for (int i = 0; i < size_a; i++) {
            int target = arr1.get(i);
            int left = 0;
            int right = size_b;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr2.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // left는 target보다 작은 원소의 개수
            result += left;
        }
        return result;
    }
    public static ArrayList<Integer> quick_sort(ArrayList<Integer> arr){
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
        sorted.addAll(quick_sort(less));
        sorted.add(pivot);
        sorted.addAll(quick_sort(greater));

        return sorted;
    }
}