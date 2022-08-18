package pro.sky.HWLibraries.employee;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employees {
    private final String firstName;
    private final String lastName;

    public Employees(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employees)) return false;
        Employees employee = (Employees) o;
        return Objects.equals(getFirstName(), employee.getFirstName())
                && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "Имя сотрудника: " + StringUtils.capitalize(firstName) + ", " + " Фамилия сотрудника: " + StringUtils.capitalize(lastName);
    }
}






