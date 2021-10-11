package Bai29;

import java.util.Scanner;

public class Manager implements Task{
    public static Customer[] customers;
    public static Ticket[] tickets;
    public static TicketSale[] ticketSales;

    public void run(){
        try {
            while (true) {
                System.out.println("Danh sach chuc nang:");
                System.out.println("1.Nhập danh sách khách hàng");
                System.out.println("2.In ra danh sach khách hàng");
                System.out.println("3.Nhập danh sách vé");
                System.out.println("4.In ra danh vé");
                System.out.println("5.Nhap hoa don");
                System.out.println("6.In danh sách mua vé");
                System.out.println("7.Sx theo ten kh");
                System.out.println("8.Sx theo loại vé");
                System.out.println("9.Số tiềm mỗi khách trả");
                boolean flag = true;
                do {
                    flag = true;
                    int chosse = 0;
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Chon chuc nang");
                    chosse = scanner.nextInt();
                    switch (chosse) {
                        case 1:
                            CreaterCustomer();
                            break;
                        case 2:
                            DisplayCustomer();
                            break;
                        case 3:
                            CreateTicket();
                            break;
                        case 4:
                            DisplayTicket();
                            break;
                        case 5:
                            input();
                            break;
                        case 6:
                            output();
                            break;
                        case 7:
                            SortName();
                            break;
                    case 8:
                        SortTicketType();
                        break;
                        case 9:
                            Total();
                            break;
                        default:
                            System.out.println("Khong co danh muc vua nhap, vui long nhap lai!");
                            flag = false;
                            break;
                    }
                }
                while (!flag);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void CreaterCustomer(){
        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Nhap so luong khách hàng");
            int a= scanner.nextInt();
            customers =new Customer[a];
            for(int i=0; i<a; i++){
                Customer customer=new Customer();
                customer.input();
                customers[i]=customer;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void DisplayCustomer(){
        System.out.println("Danh sách khách hàng:");
        for(Customer customer: customers)
        {
            customer.output();
        }
    }
    public void CreateTicket(){
        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Nhap so luong loại vé");
            int a= scanner.nextInt();
            tickets =new Ticket[a];
            for(int i=0; i<a; i++){
                Ticket ticket=new Ticket();
                ticket.input();
                tickets[i]=ticket;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void DisplayTicket(){
        System.out.println("Danh sách khách hàng:");
        for(Ticket ticket: tickets)
        {
            ticket.output();
        }
    }

    public Customer SearchCustomer(int id){
        for(Customer customer:customers){
            if(customer.getiD()==id)
                return customer;
        }
        return null;
    }
    public Ticket SearchTicket(int id){
        for(Ticket ticket:tickets){
            if(ticket.getiD()==id)
                return ticket;}
        return null;
    }
    @Override
    public void input() {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Nhap so khách hàng:");
            boolean flag=false;
            int a;
            do {
                a = sc.nextInt();
                if (a > customers.length) {
                    System.out.println("nhap lại số khách hàng:");
                    flag = true;
                }
                else flag=false;
            }while (flag);
            ticketSales=new TicketSale[a];
            boolean kiet=false;
            Customer customer;
            String date ;
                for(int i=0; i<a; i++) {
                    do {
                        System.out.println("Nhap id kh:");
                        int d;

                        boolean check = false;
                        do {
                            d = sc.nextInt();
                            customer = SearchCustomer(d);
                            if (customer == null) {
                                System.out.println("nhap lại id:");
                                check = true;
                            } else
                                check = false;
                        } while (check);
                        System.out.println("Nhap so lương vé cần mua:");
                        int b;
                        do {
                            b = sc.nextInt();
                            if (b > tickets.length) {
                                System.out.println("nhap lại so vé:");
                                flag = true;
                            } else
                                flag = false;
                        } while (flag);
                        Ticket[] tickets = new Ticket[b];

                        for (int j = 0; j < b; j++) {
                            System.out.println("Nhập id môn vé");
                            int id;
                            Ticket ticket;
                            do {
                                id = sc.nextInt();
                                ticket = SearchTicket(id);
                                if (ticket == null) {
                                    System.out.println("nhap lại id:");
                                    flag = true;
                                } else
                                    flag = false;
                            } while (flag);

                            tickets[j] = ticket;
                        }
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Nhập ngay mua(mm-yyyy):");
                        date = scanner.nextLine();

                        for (int j = 0; j < i; j++) {
                            if (ticketSales[j].customer.getiD() == customer.getiD()) {
                                for (int k = 0; k < ticketSales[j].tickets.length; k++) {
                                    for (int h = 0; h < tickets.length; h++)
                                        if (ticketSales[j].tickets[k].getiD() == tickets[h].getiD()) {
                                            if (checkdate(ticketSales[j].date, date) == false) {
                                                System.out.println("nhap lại, khách hàng không thỏa mãn yêu cầu:");
                                                kiet = true;
                                            } else {
                                                kiet = false;
                                            }
                                        } else{
                                            kiet = false;
                                        }
                                }
                            } else {
                                kiet = false;
                            }
                        }
                    } while (kiet);
                    TicketSale ticketSale=new TicketSale(customer, tickets, date);
                    ticketSales[i]=ticketSale;
                }

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public boolean checkdate(String str, String str1){
        String[] s1=str.split("-");
        String[] s2=str1.split("-");
        if(Integer.parseInt(s2[1])>Integer.parseInt(s1[1]))
        {
            return true;
        }
        else if(Integer.parseInt(s2[1])>Integer.parseInt(s1[1])){
            if(Integer.parseInt(s2[0])>Integer.parseInt(s1[0]))
                return true;
        }
        return false;
    }
    @Override
    public void output() {
        System.out.println("Danh sach:");
        for(TicketSale ticketSale: ticketSales)
        {
            ticketSale.customer.output();
            for(int i=0; i<ticketSale.tickets.length;i++){
                ticketSale.tickets[i].output();
            }
            System.out.println("Ngày mua:"+ticketSale.date);
            System.out.println("---------------------");
        }
    }

    public void SortName(){
        TicketSale tam=new TicketSale();
        for(int i=0; i<ticketSales.length-1; i++){
            for(int j=0; j<ticketSales.length; j++){
                if(ticketSales[i].customer.getName().compareTo(ticketSales[j].customer.getName())>0)
                {
                    tam=ticketSales[i];
                    ticketSales[i]=ticketSales[j];
                    ticketSales[j]=tam;
                }
            }
        }
    }

    public void SortTicketType(){
        TicketSale tam=new TicketSale();
        for(int i=0; i<ticketSales.length-1; i++){
            for(int j=0; j<ticketSales.length; j++){
                if(ticketSales[i].tickets[0].descript.compareTo(ticketSales[j].tickets[0].descript)>0)
                {
                    tam=ticketSales[i];
                    ticketSales[i]=ticketSales[j];
                    ticketSales[j]=tam;
                }
            }
        }
    }

    public void Total(){
        for (int i = 0; i < ticketSales.length - 1; i++){
            int sum=0;
            if(ticketSales[i].customer.getName().equals("Học sinh-Sinh viên")){
                for(int j=0; i<ticketSales[i].tickets.length; j++){
                    sum=sum+(ticketSales[i].tickets[j].getPrice());
                }
                System.out.println(ticketSales[i].customer.getiD()+" "+ticketSales[i].customer.getName()+ "  "+sum/2);

            }
            if(ticketSales[i].customer.getName().equals("Cán bộ trong ngành")){
                for(int j=0; i<ticketSales[i].tickets.length; j++){
                    sum=sum+(ticketSales[i].tickets[j].getPrice());
                }
                System.out.println(ticketSales[i].customer.getiD()+" "+ticketSales[i].customer.getName()+ "  "+(sum*3)/4);

            }
            if(ticketSales[i].customer.getName().equals("Khách thông thường")){
                for(int j=0; i<ticketSales[i].tickets.length; j++){
                    sum=sum+(ticketSales[i].tickets[j].getPrice());
                }
                System.out.println(ticketSales[i].customer.getiD()+" "+ticketSales[i].customer.getName()+ "  "+sum);
            }
            }
    }
}
