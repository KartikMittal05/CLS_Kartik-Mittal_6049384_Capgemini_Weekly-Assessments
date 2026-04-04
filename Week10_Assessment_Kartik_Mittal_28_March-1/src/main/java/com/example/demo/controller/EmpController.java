package com.example.demo.controller;

import com.example.demo.dto.EmpDto;
import com.example.demo.entities.Emp;
import com.example.demo.service.EmpService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;


    @GetMapping("/viewall")
    public String viewAll(Model model) {
        model.addAttribute("emps", service.getAll());
        return "viewall";
    }

    @GetMapping("/edit/{eid}")
    public String editEmp(@PathVariable("eid") Integer eid, Model model) {

        Emp emp = service.getById(eid);

        EmpDto dto = new EmpDto();
        dto.setEmpId(emp.getEmpId());
        dto.setEmpName(emp.getEmpName());
        dto.setEmpSal(emp.getEmpSal());
        dto.setEmpDoj(emp.getEmpDoj());
        dto.setDeptName(emp.getDeptName());

        model.addAttribute("empDto", dto);

        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@Valid @ModelAttribute("empDto") EmpDto dto,
                            BindingResult result) {

        if (result.hasErrors()) {
            return "edit";
        }

        Emp emp = new Emp();
        emp.setEmpId(dto.getEmpId());  
        emp.setEmpName(dto.getEmpName());
        emp.setEmpSal(dto.getEmpSal());
        emp.setEmpDoj(dto.getEmpDoj());
        emp.setDeptName(dto.getDeptName());

        service.save(emp); 

        return "redirect:/viewall";
    }


    @GetMapping("/delete/{eid}")
    public String deleteEmp(@PathVariable("eid") Integer eid,
                            RedirectAttributes ra) {

        service.delete(eid);
        ra.addFlashAttribute("msg", "Employee Deleted Successfully");

        return "redirect:/viewall";
    }
}