package pro.sky.HWLibraries.employee;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employees {
    private final String firstName;
    private final String lastName;

    public Employees(String firstName, String lastName) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase()); //приводим к toLowerCase, чтобы если введено capslock
        // или еще как то исключить и потом уже capitalize, метод который делает первую букву заглавной.
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());

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
        return "Имя сотрудника: " + firstName + ", " + " Фамилия сотрудника: " + lastName;
    }
}






