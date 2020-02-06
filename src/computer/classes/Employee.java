package computer.classes;

public class Employee extends Person {
    private String password;
    private String role;

    public Employee(int id, String firstName, String lastName, String gender, int phoneNumber, String email, String picture, String password, String role) {
        super(id, firstName, lastName, gender, phoneNumber, email, picture);
        this.password = password;
        this.role = role;
    }

    public Employee(Employee employee){
        super(employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getPhoneNumber(), employee.getEmail(), employee.getPicture());
        this.password = employee.password;
        this.role = employee.role;
    }

    public Employee() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
