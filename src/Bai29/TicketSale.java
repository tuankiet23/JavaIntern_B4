package Bai29;

import java.util.Arrays;

public class TicketSale implements Task{
    public  Customer customer;
    public  Ticket[] tickets;
    public  String date;

    @Override
    public String toString() {
        return "TicketSale{" +
                "customer=" + customer +
                ", tickets=" + Arrays.toString(tickets) +
                ", date='" + date + '\'' +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TicketSale(Customer customer, Ticket[] tickets, String date) {
        this.customer = customer;
        this.tickets = tickets;
        this.date = date;
    }

    public TicketSale() {
    }

    @Override
    public void input() {

    }

    @Override
    public void output() {
        System.out.println("TicketSale{" +
                "customer=" + customer +
                ", tickets=" + Arrays.toString(tickets) +
                ", date='" + date + '\'' +
                '}');
    }
}
