package pro.sky.HWLibraries.employeesController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HWLibraries.employee.Employees;
import pro.sky.HWLibraries.employeesService.EmployeesService;
import pro.sky.HWLibraries.exceptions.WrongNameException;

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
         return employeesService.addEmployee(lastName, firstName); // вызываем метод
     }

    @GetMapping("/remove")
    public Employees removeEmployee(@RequestParam ("firstName") String firstName,
                                    @RequestParam ("lastName") String lastName){
        return employeesService.removeEmployee(lastName, firstName); // вызываем метод
       }
    @GetMapping("/find")
    public Employees findEmployee(@RequestParam ("firstName") String firstName,
                                  @RequestParam ("lastName") String lastName){
        Employees employee = new Employees(firstName, lastName); //создаем объект внутри метода, передаем поля (конструктор)
        return employeesService.findEmployee(employee); // вызываем метод
       }
    @GetMapping("/checking")
    public String authorization(@RequestParam ("firstName") String firstName,
                                @RequestParam ("lastName") String lastName) {
        try {
            return String.valueOf(EmployeesService.checkNames(firstName, lastName));
        } catch (WrongNameException e) {
            e.printStackTrace();
            return "Недопустимое имя или фамилия!";
            }
    }
    @GetMapping
    public String getAll(){ // список с методом
       return employeesService.getAllEmployee(); // вызываем метод контроллера
    }
}
