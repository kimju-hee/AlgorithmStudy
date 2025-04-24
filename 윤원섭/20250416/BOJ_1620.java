import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도감에 수록된 포켓몬 수
        int M = Integer.parseInt(st.nextToken()); // 문제 수

        // 번호 -> 이름 해시맵
        HashMap<Integer, String> numberToName = new HashMap<>();
        // 이름 -> 번호 해시맵
        HashMap<String, Integer> nameToNumber = new HashMap<>();

        // 포켓몬 도감 정보 입력받아 두 해시맵에 저장
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();  // 포켓몬 이름 입력
            numberToName.put(i, name);
            nameToNumber.put(name, i);
        }

        // 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();

        // M개의 질문에 대해 처리
        for (int i = 0; i < M; i++) {
            String q = br.readLine(); // 한줄 입력받아 q에 저장

            // 질문이 숫자인 경우
            if (Character.isDigit(q.charAt(0))) {
                int number = Integer.parseInt(q);               // 문자열 -> 정수로 변환
                sb.append(numberToName.get(number)).append('\n');  // 번호 -> 이름 출력
            }
            // 질문이 이름인 경우
            else {
                sb.append(nameToNumber.get(q)).append('\n');   // 이름 -> 번호 출력
            }
        }
        System.out.print(sb);
    }
}
