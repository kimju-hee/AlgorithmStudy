package S20250416;
import java.util.*;

public class BOJ_10773 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        sc.nextLine();
        for(int i=0;i<k;i++){
            int write = sc.nextInt();
            if(write == 0){
                stack.pop();
            }else{
                stack.push(write);
            }
        }
        int result = 0;
        for(int ww : stack){
            result +=ww;
        }
        System.out.println(result);
    }
}
