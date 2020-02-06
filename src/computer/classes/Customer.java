package computer.classes;

public class Customer extends Person {
    private String address;

    public Customer(String firstName, String lastName, String gender, int phoneNumber, String email, String picture, String address) {
        super(firstName, lastName, gender, phoneNumber, email, picture);
        this.address = address;
    }

    public Customer() {
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
