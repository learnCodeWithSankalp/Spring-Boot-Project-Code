package com.learncodewithsankalp.contoller;

import com.learncodewithsankalp.entity.Employee;
import com.learncodewithsankalp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployee(Model theModel){
       List<Employee> listEmployee=employeeService.findAllEmployee();
       theModel.addAttribute("employees",listEmployee);
       return  "employee-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theMdel){
        Employee theEmployee=new Employee();
        theMdel.addAttribute("employee",theEmployee);
         return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFromForUpdate")
    public String showFromForUpdate(@RequestParam("employeeId")int theId,Model theModel){
         Employee theEmployee=employeeService.findEmployeeById(theId);
         theModel.addAttribute("employee",theEmployee);
         return "employee-form";
    }

    @GetMapping("/showFromForDelete")
    public String showFromForDelete(@RequestParam("employeeId")int theId){
        Employee theEmployee=employeeService.findEmployeeById(theId);
        employeeService.deleteEmployee(theEmployee);
        return "redirect:/employees/list";
    }



}
