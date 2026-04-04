package com.example.demo.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.*;

public class EmpDto {

    private Integer empId;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 25, message = "Name must be 3-25 chars")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabets allowed")
    private String empName;

    @NotNull(message = "Salary required")
    @Min(value = 1000, message = "Minimum salary is 1000")
    @Max(value = 500000, message = "Maximum salary is 500000")
    private Double empSal;

    @NotNull(message = "Date required")
    @FutureOrPresent(message = "Date must be today or future")
    private LocalDate empDoj;

    @NotBlank(message = "Department required")
    @Pattern(regexp = "^(hr|production)$", message = "Only hr or production allowed")
    private String deptName;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public LocalDate getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(LocalDate empDoj) {
		this.empDoj = empDoj;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

    
}