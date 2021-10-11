public class Bai5 {
    public StringBuilder Convert(String str){
        String[] str1=str.split("\\s");
        StringBuilder str2=new StringBuilder();
        str2.append(str1[str1.length-1]);
        str2.append(" ");
        str2.append(str1[0]);
        str2.append(" ");
        for(int i=1; i<str1.length-1; i++){
            str2.append(str1[i]);
            str2.append(" ");
        }
        return str2;
    }

    public static void main(String[] args) {
        Bai5 bai5=new Bai5();
        System.out.println(bai5.Convert("Pham Tuan Kiet"));
    }
}
