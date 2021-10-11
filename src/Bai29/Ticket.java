package Bai29;

import java.util.Scanner;

public class Ticket implements Task {
    private static int iDAuto=9999;
    public int iD;
    public String descript;
    public int price;

    public static int getiDAuto() {
        return iDAuto;
    }

    public static void setiDAuto(int iDAuto) {
        Ticket.iDAuto = iDAuto;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Ticket(){
        this.iD=iDAuto++;
    }
    public Ticket(int iD, String descript, int price) {
        this.iD = iD;
        this.descript = descript;
        this.price = price;
    }

    @Override
    public void input() {
        try{
            Scanner sc=new Scanner(System.in);
            this.setiD(iDAuto);
            System.out.println("Mô tả:");
            this.setDescript(sc.nextLine());
            System.out.printf("Đơn giá:");
            this.setPrice(sc.nextInt());
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void output() {
        System.out.println("Ticket{id:"+iD+" Mô tả:"+descript+" Giá:"+price+"}");
    }
}
