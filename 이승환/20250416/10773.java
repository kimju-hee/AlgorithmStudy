import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        long sum=0;
        for(int i=0;i<K;i++){
            int n = Integer.parseInt(br.readLine());
            if (n==0) sum-=stack.pop(); //0이 나오면 스택과 sum에서 값 제거
            else sum+=stack.push(n); //0이 아니면 스택과 sum에 값 누적
        }
        System.out.print(sum);
    }
}