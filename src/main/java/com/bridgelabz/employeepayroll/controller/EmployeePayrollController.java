package com.bridgelabz.employeepayroll.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.dto.ResponseDto;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.services.IEmployeePayrollService;
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDto> getEmployeeData() {
		List<EmployeePayrollData> empDataList=null;
		empDataList=employeePayrollService.getEmployeePayrolldata();
		ResponseDto respDto=new ResponseDto("Get Call Success",empDataList);
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
	}
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDto> getEmployeeData(@PathVariable("empId") int empId) {
		EmployeePayrollData empData=null;
		empData=employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDto respDto=new ResponseDto("Get Call For Id Success",empData);
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> addEmployeeData(@RequestBody EmployeePayrollDto employeePayrolldto) {
		EmployeePayrollData empData=null;
		empData=employeePayrollService.createEmployeePayrollData(employeePayrolldto);
		ResponseDto respDto=new ResponseDto("Created Employee Payroll Data Successfully",empData);
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateEmployeeData(@RequestBody EmployeePayrollDto employeePayrolldto) {
		EmployeePayrollData empData=null;
		empData=employeePayrollService.updateEmployeePayrollData(employeePayrolldto);
		ResponseDto respDto=new ResponseDto("Updated Employee Payroll Data Successfully",empData);
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDto> deleteEmployeeData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDto respDto=new ResponseDto("Deleted Successfully","Deleted id:"+empId);
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
	}
}	