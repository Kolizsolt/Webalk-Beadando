package iit.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.me.entity.RequestEntity;
import iit.me.entity.StudentEntity;
import iit.me.entity.TemplateEntity;
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
	void createStudent(@RequestBody StudentEntity newStudent){
		studentService.newStudent(newStudent);
	}
	
	@GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<StudentEntity> students(){
		return studentService.listStudents();
	}
	
	@PostMapping(path="/request", consumes=MediaType.APPLICATION_JSON_VALUE)
	void submitRequest(@RequestBody RequestEntity newRequest){
		studentService.submitRequest(newRequest);
	}
	
	@GetMapping(path="/request", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<RequestEntity> listRequests(){
		return studentService.listRequests();
	}
	
	@GetMapping(path="/ownrequests/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	List<RequestEntity> findByStudentId(@PathVariable("id") long studId){
		return studentService.findByStudentId(studId);
	}
	
	@GetMapping(path="/template", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<TemplateEntity> listTemplates(){
		return studentService.listTemplates();
	}
	
	@GetMapping(path="/template/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	TemplateEntity findOneTemplate(@PathVariable("id") long templateId){
		return studentService.findTemplate(templateId);
	}

}
