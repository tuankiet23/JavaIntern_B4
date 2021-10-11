public class Bai1 {
    private void check() {
        for (int i=100000; i<1000000; i++){
            String str=String.valueOf(i);
            if (kt(str)==true){
                System.out.println(i);
            }
        }
    }
    private boolean kt(String str) {
        int a = str.length();
        for (int i=0; i<a; i++){
            if (str.charAt(i) == str.charAt(a-i-1)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
       Bai1 bai1=new Bai1();
       bai1.check();
    }
}
