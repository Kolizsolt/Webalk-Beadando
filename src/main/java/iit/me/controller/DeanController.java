package iit.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.me.entity.RequestEntity;
import iit.me.service.DeanService;

@RestController
@RequestMapping("/dean")
public class DeanController {
	
	private DeanService deanService;

	@Autowired
	public DeanController(DeanService deanService) {
		super();
		this.deanService = deanService;
	}
	
	
	@GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<RequestEntity> listRequests(){
		return deanService.listRequests();
	}
	
	@PutMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void verdict(@PathVariable("id") long requestId){
		deanService.makeVerdict(requestId);
	}
	
	//addTemplate

}
