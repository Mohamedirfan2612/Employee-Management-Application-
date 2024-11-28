package com.example.Employe_management_System.Controller;


import com.example.Employe_management_System.Entity.Employee;
import com.example.Employe_management_System.Service.EmployeeService;
import jakarta.persistence.GeneratedValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // Handler method to handle list employee and return mode and view

    @GetMapping("/employee")
    public String listEmployee(Model model) {
        model.addAttribute("employee", employeeService.getAllEmployee());
        return "employee";

    }

    @GetMapping("/employee/new")
    public String createEmployeeForm(Model model) {

        // create employee object to hold employee form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";

    }

    @PostMapping("/employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";

    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit_employee";

    }

    @PostMapping("/employee/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @ModelAttribute("employee") Employee employee,
                                 Model model) {
        // get student from database by id
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setId(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // save updated student object
        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employee";
    }

    // handler method to handle delete student request

    @GetMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    @GetMapping("/employee/view/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "view_employee";


    }
}



