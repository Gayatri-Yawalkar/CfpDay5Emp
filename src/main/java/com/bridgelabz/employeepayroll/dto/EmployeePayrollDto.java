package com.bridgelabz.employeepayroll.dto;
public class EmployeePayrollDto {
	public String name;
	public long salary;
	public EmployeePayrollDto(String name,long salary) {
		this.name=name;
		this.salary=salary;
	}
	@Override
	public String toString() {
		return "Name="+name+" salary="+salary;
	}
}
