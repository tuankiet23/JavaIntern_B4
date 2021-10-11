public class Bai2 {
    public StringBuilder Convert(String str){
        String[] str1=str.split("");
        StringBuilder str2=new StringBuilder();
        for(int i=0; i<str1.length; i++)
        {
            if(i%2!=0){
                str1[i]=str1[i].toLowerCase();
                str2.append(str1[i]);
            }
            else{
                str1[i]=str1[i].toUpperCase();
                str2.append(str1[i]);
            }

        }
        return str2;
    }
    public static void main(String[] args) {
        Bai2 bai2=new Bai2();
        String str="efewrgrgtg";
        System.out.println( bai2.Convert(str));

    }
}
