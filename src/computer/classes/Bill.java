package computer.classes;

import java.util.Objects;

public class Bill {
    private int id;

    private Customer customer;
    private Employee employee;

    private int receiveMoney;
    private String billDate;

    private Transport transport;
    private int totalMoney;

    public Bill(Customer customer, Employee employee, Transport transport, int receiveMoney,
                int totalMoney) {
        this.customer = customer;
        this.employee = employee;
        this.transport = transport;
        this.receiveMoney = receiveMoney;
        this.totalMoney = totalMoney;
        this.billDate = new DateController().getShortDateTimes();
    }

    public Bill(int id, Customer customer, Employee employee, Transport transport, int receiveMoney
            , int totalMoney, String billDate) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.transport = transport;
        this.receiveMoney = receiveMoney;
        this.totalMoney = totalMoney;
        this.billDate = billDate;
    }

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getReceiveMoney() {
        return receiveMoney;
    }

    public void setReceiveMoney(int receiveMoney) {
        this.receiveMoney = receiveMoney;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;
        Bill bill = (Bill) o;
        return getId() == bill.getId();
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customer=" + customer +
                '}';
    }
}
