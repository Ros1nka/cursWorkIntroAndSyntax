import java.util.Objects;

public class Employee {
    private String firstName;
    private String patronymic;
    private String lastName;
    private int department;
    private double salary;
    private int id;

    public Employee(String lastName, String firstName, String patronymic, int department, int salary) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = Counter.getAndIncrease();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(patronymic, employee.patronymic) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, patronymic, lastName, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public String getIdAndName() {
        return "id " + id + ", " + lastName + " " + firstName.charAt(0) + ". " + patronymic.charAt(0) + ".";
    }
}
