package iit.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.me.entity.RequestEntity;
import iit.me.entity.TeacherEntity;
import iit.me.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	private TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}
	
	@PostMapping(path="", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createTeacher(@RequestBody TeacherEntity newTeacher){
		teacherService.newTeacher(newTeacher);
	}
	
	@GetMapping(path="/request", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<RequestEntity> listRequests(){
		return teacherService.listRequests();
	}
	
	@PutMapping(path="/{id}/comment", consumes=MediaType.APPLICATION_JSON_VALUE)
	void teacherComment(@PathVariable("id") long requestId, @PathVariable String comment){
		teacherService.comment(requestId, comment);
	}
	
	@PutMapping(path="/{id}/forward", consumes=MediaType.APPLICATION_JSON_VALUE)
	void forward(@PathVariable("id") long requestId){
		teacherService.forwardRequest(requestId);
	}

}
