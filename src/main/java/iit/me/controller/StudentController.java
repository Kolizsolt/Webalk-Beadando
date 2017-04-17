package iit.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.me.entity.RequestEntity;
import iit.me.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping(path="", consumes=MediaType.APPLICATION_JSON_VALUE)
	void submitRequest(@RequestBody RequestEntity newRequest){
		studentService.submitRequest(newRequest);
	}
	
	@GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<RequestEntity> listRequests(){
		return studentService.listRequests();
	}

}
