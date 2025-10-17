package iuh.fit.se.controllers;

import iuh.fit.se.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class employeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String showList(Model model) {
//        model.addAttribute("employees", employeeService.getAll());
        return "listEmployee";
    }
}
