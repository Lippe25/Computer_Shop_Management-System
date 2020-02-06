package computer.classes;

import java.util.Objects;

public class Transport {
    private int id;
    private String type;
    private int price;

    public Transport(int id, String type, int price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public Transport() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;
        Transport transport = (Transport) o;
        return getId() == transport.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return type + " " +price;
    }
}
