package com.bridgelabz.employeepayroll.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	List<EmployeePayrollDto> empDataList=new ArrayList<EmployeePayrollDto>();
	@Override
	public List<EmployeePayrollDto> getEmployeePayrolldata() {
		empDataList.add(1,new EmployeePayrollDto("Gayo",30010));
		return empDataList;
	}
	@Override
	public EmployeePayrollDto getEmployeePayrollDataById(int empId) {
		EmployeePayrollDto empData=null;
		empData=empDataList.get(empId);
		return empData;
	}
	@Override
	public EmployeePayrollDto createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
		empDataList.add(employeePayrollDto);
		return employeePayrollDto;
	}
	@Override
	public EmployeePayrollDto updateEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
		empList.set(1,employeePayrollDto);
		return employeePayrollDto;
	}
	@Override
	public void deleteEmployeePayrollData(int empId) {
		empList.remove(empId);
	}
}
