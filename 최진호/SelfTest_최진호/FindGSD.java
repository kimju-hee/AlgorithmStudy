package SelfTest_최진호;
import java.util.*;
import java.io.*;

public class FindGSD {
    public static void main(String[] args) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gsd(a,b));
    }
    public static int gsd(int a,int b){
        if(b==0){
            return a;
        }else{
            return gsd(b, a%b);
        }
    } 
}
