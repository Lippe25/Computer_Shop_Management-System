package computer.classes;

import java.util.Objects;

public class Procurement {
    private int id;

    private Employee employee;
    private Provider provider;

    private int quantity;
    private int totalPrice;
    private String date;

    public Procurement(Employee employee, Provider provider, int quantity, int totalPrice) {
        this.employee = employee;
        this.provider = provider;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date =  new DateController().getShortDateTimes();
    }

    public Procurement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Procurement)) return false;
        Procurement that = (Procurement) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Procurement{" +
                "employee=" + employee.getFirstName() +
                ", provider=" + provider.getFirstName() +
                '}';
    }
}
