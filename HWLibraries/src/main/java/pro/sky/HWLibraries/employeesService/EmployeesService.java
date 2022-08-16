package pro.sky.HWLibraries.employeesService;


import org.springframework.stereotype.Service;
import pro.sky.HWLibraries.employee.Employees;
import pro.sky.HWLibraries.exceptions.EmployeeAlreadyAddedException;
import pro.sky.HWLibraries.exceptions.EmployeeNotFoundException;
import pro.sky.HWLibraries.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesService {
    List<Employees> employees = new ArrayList<>(List.of(
                new Employees("Иван Иванович", "Иванов"),
                new Employees("Иван Петрович", "Иванов"),
                new Employees("Иван Иванович", "Сидоров"),
                new Employees("Михаил Иванович", "Зверев"),
                new Employees("Людмила Петровна", "Клюева"),
                new Employees("Егор Александрович", "Иванов"),
                new Employees("Сергей Сергеевич", "Кузнецов"),
                new Employees("Сергей Валерьевич", "Клоков"),
                new Employees("Светлана Игоревна", "Куркова"),
                new Employees("Елена Александровна", "Михалева")
    ));
    public Employees addEmployee(Employees employee) {
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < 11){
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }
    public Employees removeEmployee(Employees employee) {
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
    public List <Employees> getAll() { // создается список со стандартным методом getAll()
        //return employees.toString(); // если выводить список в формате заданном в
        // toString(метод public String getAllEmployee) например.
        return new ArrayList<>(employees); //возвращаем списочный массив
    }


}


