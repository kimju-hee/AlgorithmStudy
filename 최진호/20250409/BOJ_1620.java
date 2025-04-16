import java.util.*;

public class BOJ_1620 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String name = sc.nextLine(); 
            map.put(i,name);
        }

        for(int i=0;i<m;i++){
            
            System.out.println("");
        }
        sc.close();
    }
}
