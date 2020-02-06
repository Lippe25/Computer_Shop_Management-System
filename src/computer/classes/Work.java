package computer.classes;

import java.util.Objects;

public class Work {
    private Employee employee;
    private Store store;
    private String date;

    public Work(Employee employee, Store store) {
        this.employee = employee;
        this.store = store;
        this.date =  new DateController().getShortDateTimes();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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
        if (!(o instanceof Work)) return false;
        Work work = (Work) o;
        return Objects.equals(getEmployee(), work.getEmployee()) &&
                Objects.equals(getStore(), work.getStore()) &&
                Objects.equals(getDate(), work.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee(), getStore(), getDate());
    }

    @Override
    public String toString() {
        return "Work{" +
                "employee=" + employee +
                ", store=" + store +
                '}';
    }
}
