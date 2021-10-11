import java.util.Scanner;

public class Bai7 {
    public String Delete(String str1, String str2){
        int n = str2.length();
        String s = "";
        str1 = str1.replaceAll(str2, s);
        return str1;
    }
public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    String str1=scanner.nextLine();
    String str2=scanner.nextLine();
    Bai7 bai7=new Bai7();
    System.out.println(bai7.Delete(str1, str2));
    }
}
