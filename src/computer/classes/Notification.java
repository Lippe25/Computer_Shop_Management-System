package computer.classes;

import java.util.Objects;

public class Notification {
    private int id;

    private Employee employee;

    private String message;
    private String date;
    private Boolean read = false;

    public Notification(Employee employee, String message, String date) {
        this.employee = employee;
        this.message = message;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public Boolean getRead() {
        return read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Notification{" +
                "message='" + message + '\'' +
                ", emp=" + employee +
                '}';
    }
}
