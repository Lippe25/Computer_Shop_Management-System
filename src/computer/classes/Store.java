package computer.classes;

import java.util.Objects;

public class Store {
    private int id;
    private String name;
    private String address;
    private int phoneNumber;
    private String email;
    private String date;
    private String description;

    public Store(int id, String name, String address, int phoneNumber, String email, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date =  new DateController().getShortDateTimes();
        this.description = description;
    }

    public Store(Store store){
        this.id = store.id;
        this.name = store.name;
        this.address = store.address;
        this.phoneNumber = store.phoneNumber;
        this.email = store.email;
        this.date = store.date;
        this.description = store.description;
    }

    public Store() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return getId() == store.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                '}';
    }
}
