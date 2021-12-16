package com.rameshfadtare.RESTfulWebSevices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentBeanController {
	
	
	//returning a bean-demo
	
	@GetMapping("/student-bean")
	public StudentBean returnStudentBean()
	{
		return new StudentBean("Balasuriyan", "S P");
	}
	
	
	//returning a list of bean-demo
	
	@GetMapping("/student-bean-list")
	public List<StudentBean> returnStudentBeanList()
	{
		List<StudentBean> list=new ArrayList<StudentBean>();
		list.add(new StudentBean("Balasuriyan", "S P"));
		list.add(new StudentBean("Balaji", "S"));
		list.add(new StudentBean("Jayakar", "Victor"));
		return list;
	}
	
	
	// using a @PathVariable demo
	
	@GetMapping("/student/{lastName}/{firstName}")
	public StudentBean returnLastName(@PathVariable String lastName,@PathVariable String firstName)
	{
		return new StudentBean(firstName,lastName);
	}
	
	
	// @RequestParam or query parameters demo
	
	//http://localhost:8080/student/query?firstName=Deepak&lastName=Kumar
	
	@GetMapping("/student/query")
	public StudentBean requestParamDemo(@RequestParam(name="firstName") String firstName,@RequestParam(name="lastName") String lastName)
	{
		return new StudentBean(firstName,lastName);
	}

}
