import java.io.*;
import java.util.*;

public class BOJ_10773 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                if (m==0){
                    stack.pop();
                }else{
                    stack.push(m);
                }
            }
            int sum = stack.stream().mapToInt(Integer::intValue).sum();
            System.out.print(sum);
        }
    }
