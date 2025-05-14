import java.util.*;

public class BOJ_9184 {
    static int[][][] arr = new int[101][101][101];// 범위가 -50~50이니 0포함 101개!

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Arrays.fill(arr,1); 은 1차원 배열에만 해당됨!
        for(int i=0;i<101;i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(arr[i][j], -1);
            }
        }

        //그래도 재귀니까 Top Down 방식을 사용해보자!!
        while(true){
            String[] input = sc.nextLine().split(" ");
            //숫자 범위는 -50~50, 음수인덱스를 만들 수 없으니
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            if(a==-1&&b==-1&&c==-1){
                break;
            }
            System.out.println("w("+a+", "+b+", "+c+") = "+w(a,b,c));
        }
    }
    public static int w(int a, int b, int c){
        int aa = a+50, bb = b+50, cc = c+50; //인덱싱 변수
        if(arr[aa][bb][cc] == -1) {
            if (a <= 0 || b <= 0 || c <= 0) {
                arr[aa][bb][cc] = 1;
            } else if (a > 20 || b > 20 || c > 20) {
                arr[aa][bb][cc] = w(20, 20, 20);
            } else if (a < b && b < c) {
                arr[aa][bb][cc] = w(a, b, c-1) + w(a, b - 1, c-1) - w(a,b-1,c);
            } else {
                arr[aa][bb][cc] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            }
        }
        return arr[aa][bb][cc];
    }
}
