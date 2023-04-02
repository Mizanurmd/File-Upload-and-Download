package com.Spring.file.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Spring.file.model.Employee;
import com.Spring.file.service.EmployeeService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/")
	public String home(Model m) {
		List<Employee> employeeList = empService.getAllEmployees();
		m.addAttribute("employeeList",employeeList);
		return "/view/index.html";
		
	}
	
	//////////// File upload controller here //////////////
	@PostMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file, Model m) throws IOException {
		Employee employee = new Employee();
		String fileName = file.getOriginalFilename();
		employee.setProfilePicture(fileName);
		employee.setContent(file.getBytes());
		employee.setSize(file.getSize());
		empService.createEmployee(employee);
		
		m.addAttribute("Success", "File upload Successfully!!!!");
		return "/view/index.html";
	}
	
	//////////// File download controller here ////////////
	@GetMapping("/download")
	public void  downloadFile(@Param("id")Long id, HttpServletResponse response, Model m) throws IOException {
		Optional<Employee>temp = empService.getSingleEmployee(id);
		if(temp !=null) {
			Employee employee = temp.get();
			response.setContentType("application-strem");
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename= " + employee.getProfilePicture();
			response.setHeader(headerKey, headerValue);
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(employee.getContent());
			outputStream.close();
			
		}
		
	}
	
	//////////// Get image controller here /////////////
	
	@GetMapping("/image")
	public void showImage(@Param("id") Long id, HttpServletResponse response, Optional<Employee>employee) throws IOException {
		employee = empService.getSingleEmployee(id);
		response.setContentType("/image/jpeg, image/jpg, image/gif, image/pdf");
		response.getOutputStream().write(employee.get().getContent());
		response.getOutputStream().close();
		
		
	}

}
