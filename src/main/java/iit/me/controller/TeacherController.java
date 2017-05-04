package iit.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.me.entity.RequestEntity;
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
	
	@GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<RequestEntity> listRequests(){
		return teacherService.listRequests();
	}
	
	//comment
	
	//forwardRequest

}
