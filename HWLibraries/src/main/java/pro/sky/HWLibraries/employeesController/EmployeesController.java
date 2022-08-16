package pro.sky.HWLibraries.employeesController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HWLibraries.employee.Employees;
import pro.sky.HWLibraries.employeesService.EmployeesService;


import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private static EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }
    @GetMapping("/add")
    public Employees addEmployee(@RequestParam ("firstName") String firstName,
                                 @RequestParam ("lastName") String lastName){
        Employees employee = new Employees(firstName, lastName); //создаем объект внутри метода, передаем поля (конструктор)
       return employeesService.addEmployee(employee); // вызываем метод
        //return "Сотрудник добавлен успешно";
    }
    @GetMapping("/remove")
    public Employees removeEmployee(@RequestParam ("firstName") String firstName,
                                    @RequestParam ("lastName") String lastName){
        Employees employee = new Employees(firstName, lastName); //создаем объект внутри метода, передаем поля (конструктор)
       return employeesService.removeEmployee(employee); // вызываем метод
        //return "Сотрудник удален";
    }
    @GetMapping("/find")
    public Employees findEmployee(@RequestParam ("firstName") String firstName,
                                  @RequestParam ("lastName") String lastName){
        Employees employee = new Employees(firstName, lastName); //создаем объект внутри метода, передаем поля (конструктор)
        return employeesService.findEmployee(employee); // вызываем метод
        //return "Сотрудник найден";
    }
    @GetMapping
    public List<Employees> getAll(){ // список с методом
       return employeesService.getAll(); // вызываем метод контроллера
    }
}
