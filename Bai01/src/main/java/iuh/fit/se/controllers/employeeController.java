package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;
import java.util.List;

@Controller
public class employeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("employees", employeeService.getAll());
//        employeeService.getAll().forEach(System.out::println);
        return "listEmployee";
    }

    @GetMapping("/find")
    public String findEmployee(Model model, @RequestParam("keyName") String keyName) {
        List<Employee> employees = employeeService.findByKeyName(keyName);
        model.addAttribute("employees", employees);
        return "listEmployee";
    }
    @GetMapping("/remove")
    public String removeEmployee(Model model, @RequestParam("id") int id) {
        employeeService.removeById(id);
        model.addAttribute("employees", employeeService.getAll());
        return "listEmployee";
    }
    @GetMapping("/update")
    public String updateEmployee(Model model, @RequestParam("id") int id) {
        int idUpdate = id;
        model.addAttribute("idUpdate", idUpdate);
        model.addAttribute("employees", employeeService.getAll());
        return "listEmployee";
    }
    @GetMapping("/openFormAdd")
    public String formAdd(Model model) {
        return "addEmployee";
    }
    @GetMapping("/add")
    public String addEmployee(Model model, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employee em = new Employee();
        em.setFirstName(firstName);
        em.setLastName(lastName);
        employeeService.save(em);
        model.addAttribute("employees", employeeService.getAll());
        return "listEmployee";
    }

    @PostMapping("/actionUpdate")
    public String actionUpdate(Model model, @RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employee em = employeeService.findById(id);
        em.setFirstName(firstName);
        em.setLastName(lastName);
        employeeService.save(em);
        return "redirect:/";
    }
}
