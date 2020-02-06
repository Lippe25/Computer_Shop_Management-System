package computer.classes;

public class Provider extends Person {
    private String companyName;

    public Provider(String companyName, String firstName, String lastName, String gender, int phoneNumber, String email, String picture) {
        super(firstName, lastName, gender, phoneNumber, email, picture);
        this.companyName = companyName;
    }

    public Provider() {

        super();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}