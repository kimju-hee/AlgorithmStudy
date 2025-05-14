import java.io.*;
import java.util.*;

public class Main{
    
    static Map<String, Integer> archive = new HashMap<>();// 다른 저장형태로 가능할 것 같은데
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            //세 정수 초기화 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            //모두 -1일 경우 종료
            if (a == -1 && b == -1 && c == -1) break;
            
            String key = "w(" + a + ", " + b + ", "  + c + ")";
            System.out.println(key + " = " +  archive.get(key));

        }
    }

    // 재귀함수 w
    public static int w(int a, int b, int c){
        String key = "w(" + a + ", " + b + ", "  + c + ")";
        int value;
        
        // 사전에 키가 없다면
        if (!archive.containsKey(key)){ 
            if (a <= 0 || b <= 0 || c <= 0){
                value = 1;

            } else if (a > 20 || b > 20 || c > 20){
                value = w(20, 20, 20);

            } else if (a < b && b < c){
                value = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

            } else{
                value = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

            }

            // 키, 값 쌍 넣기
            archive.put(key,value);

            return value;
        } else return archive.get(key); //값이 있다면 찾아서 리턴
    }
}