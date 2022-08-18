package pro.sky.HWLibraries.employeesService;


import org.springframework.stereotype.Service;
import pro.sky.HWLibraries.employee.Employees;
import pro.sky.HWLibraries.exceptions.EmployeeAlreadyAddedException;
import pro.sky.HWLibraries.exceptions.EmployeeNotFoundException;
import pro.sky.HWLibraries.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import pro.sky.HWLibraries.exceptions.WrongNameException;

@Service
public class EmployeesService {
    List<Employees> employees = new ArrayList<>(List.of(
                new Employees("Иван", "Иванов"),
                new Employees("Яков", "Иванов"),
                new Employees("Иван", "Сидоров"),
                new Employees("Михаил", "Зверев"),
                new Employees("Людмила", "Клюева"),
                new Employees("Егор", "Иванов"),
                new Employees("Сергей", "Кузнецов"),
                new Employees("Сергей", "Клоков"),
                new Employees("Светлана", "Куркова"),
                new Employees("Елена", "Михалева")
    ));

    public static boolean checkNames (String firstName, String lastName){
        if(!StringUtils.isAlpha(firstName)) {
            throw new WrongNameException();
        }
        if (!StringUtils.isAlpha(lastName)) {
            throw new WrongNameException();
        }
        return true;
    }
    public Employees addEmployee(String firstName, String lastName) {
        Employees employee = new Employees(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (!checkNames(firstName, lastName)) {
            throw new WrongNameException();
        }
        if (employees.size() < 11) {
            employees.add(employee);
        } else {
            throw new EmployeeStorageIsFullException();
        }
        return employee;
    }
    public Employees removeEmployee(String firstName, String lastName) {
        Employees employee = new Employees(firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }
    public Employees findEmployee(Employees employee) {
       if (!employees.contains(employee)){
           throw new EmployeeNotFoundException();
       }
       return employee;
    }
    public String getAllEmployee() {
        return employees.toString();

    }


}


