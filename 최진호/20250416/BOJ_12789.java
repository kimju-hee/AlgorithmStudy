package S20250416;
import java.util.*;
import java.io.*;

public class BOJ_12789 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] inputs = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int i = arr.length-1; i>=0; i--){
            stack1.push(arr[i]);
        }
        int next=1;
        while(next <= n){
            if(stack1.isEmpty() && stack2.isEmpty()){
                break;
            }else if(!stack1.isEmpty() && next == stack1.peek()){
                next ++;
                stack1.pop();
            }else if(!stack2.isEmpty() && stack2.peek()==next){
                next ++;
                stack2.pop();
            }else if(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }else{
                break;
            }
        }
        if(next == n+1){System.out.println("Nice");}
        else{System.out.println("Sad");}
    }
}
