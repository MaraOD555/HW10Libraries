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
         return employeesService.addEmployee(firstName, lastName);
     }

    @GetMapping("/remove")
    public Employees removeEmployee(@RequestParam ("firstName") String firstName,
                                    @RequestParam ("lastName") String lastName){
        return employeesService.removeEmployee(firstName, lastName);
       }
    @GetMapping("/find")
    public Employees findEmployee(@RequestParam ("firstName") String firstName,
                                  @RequestParam ("lastName") String lastName){
        return employeesService.findEmployee(firstName, lastName);
       }

    @GetMapping
    public String getAll(){
       return employeesService.getAllEmployee();
    }
}
