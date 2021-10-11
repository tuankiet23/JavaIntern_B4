package Bai29;

import java.util.Scanner;

public class Customer extends Person implements Task {
    public String customerGroup;

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }


    public Customer() {
    }

    public Customer(int iD, String name, String adress, String phone, String customerGroup) {
        super(iD, name, adress, phone);
        this.customerGroup = customerGroup;
    }


    @Override
    public void input() {
        try {
            super.input();
            Scanner sc=new Scanner(System.in);
            System.out.println("Nhóm khách:");
            String[] arr = {"Học sinh-Sinh viên", "Cán bộ trong ngành", "Khách thông thường"};

            boolean check = true;
            do {
                check = true;
                int a = 0;
                System.out.println("Chon nhóm khách hàng:");
                System.out.println("1.Học sinh-Sinh viên:");
                System.out.println("2.án bộ trong ngành");
                System.out.println("3.Khách thông thường");
                a = sc.nextInt();
                switch (a) {
                    case 1:
                        this.setCustomerGroup(arr[0]);
                        break;
                    case 2:
                        this.setCustomerGroup(arr[1]);
                        break;
                    case 3:
                        this.setCustomerGroup(arr[2]);
                        break;
                    default:
                        System.out.println("Khong co danh muc vua nhap, vui long nhap lai!");
                        check = false;
                        break;
                }
            }
            while (!check) ;
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void output() {
            super.output();
            System.out.println(customerGroup+"}");
    }
}
