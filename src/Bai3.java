public class Bai3 {
    public StringBuilder Convert(String str){
        String[] str1=str.split("\\s");
        StringBuilder str2=new StringBuilder();
        for(int i=0; i<str1.length; i++)
        {
            String firstLetters=str1[i].substring(0,1).toUpperCase();
            String remainingLetters=str1[i].substring(1, str1[i].length()).toLowerCase();
                str2.append(firstLetters);
                str2.append(remainingLetters);
                str2.append(" ");
        }
        return str2;
    }
    public static void main(String[] args) {
        Bai3 bai3=new Bai3();
        String str="pham tuan kiet";
        System.out.println( bai3.Convert(str));

    }
}
