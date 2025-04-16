import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        
        Stack<Integer> stack = new Stack<>(); //한 명씩만 설 수 있는 줄 (아래 줄)
        Queue<Integer> queue = new LinkedList<>(); //현재 줄 서있는 곳

        for(int i=0;i<N;i++){
            queue.add(sc.nextInt());
        }
        int c = 1;
        while(!queue.isEmpty() || !stack.isEmpty()){ //두 줄이 전부 빌 때까지 반복
            if (!queue.isEmpty() && queue.peek()== c){ // 다음 사람이 현재 줄에 있을 때
                c++;
                queue.remove();
            } else if (!stack.isEmpty() && stack.peek()==c){ //다음 사람이 아래 줄에 있을 때
                c++;
                stack.pop();
            } else if (queue.isEmpty() && !stack.isEmpty() && stack.peek()!=c){ //다음 사람이 두 줄에 모두 나타나지 않았을 때
                break;
            }else{
                stack.push(queue.remove()); // 다음 사람 차례가 아니라서 아래 줄로 이동해서 기다릴 때
            }
        }
        if (c == N + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }   
    }
}