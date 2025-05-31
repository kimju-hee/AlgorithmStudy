import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] mosqitoes = new int[N][2];
        
        int max = 0;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            mosqitoes[i][0] = Integer.parseInt(st.nextToken());
            mosqitoes[i][1] = Integer.parseInt(st.nextToken());
            if (mosqitoes[i][1] > max) {
                max = mosqitoes[i][1];
            }
        }

        int[] time = new int[max + 1];
        for (int i = 0; i < N; i++){
            int E = mosqitoes[i][0];
            int X = mosqitoes[i][1];
            time[E]++;
            time[X]--;
        }

        max = 0;
        for (int i = 1; i < time.length; i++){
            time[i] += time[i - 1];
            if (time[i] > max) {
                max = time[i];
            }
        }
        System.out.println(max);
        
        int count = 0;
        int maxLength = 0;
        int start = 0, end = 0;
        for (int i = 0; i < time.length; i++){
            if (time[i] == max){
                count++;
                end = i;
                if (i > 0 && time[i - 1] != max){
                    start = i;
                }
            } else{
                maxLength = Math.max(maxLength, count);
                count = 0;
            }
        }
        System.out.println(start + " " + (end + 1));
    }
}