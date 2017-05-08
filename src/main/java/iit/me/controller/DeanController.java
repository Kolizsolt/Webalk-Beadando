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

import iit.me.entity.DeanEntity;
import iit.me.entity.RequestEntity;
import iit.me.entity.TemplateEntity;
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
	
	
	@PostMapping(path="", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createDean(@RequestBody DeanEntity newDean){
		deanService.newDean(newDean);
	}
	
	@GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<DeanEntity> deans(){
		return deanService.listDeans();
	}
	
	@GetMapping(path="/requests", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<RequestEntity> listRequests(){
		return deanService.listRequests();
	}
	
	@GetMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	RequestEntity findOneRequest(@PathVariable long requestId){
		return deanService.findRequest(requestId);
	}
	
	@PutMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void verdict(@PathVariable("id") long requestId){
		deanService.acceptVerdict(requestId);
	}
	
	@PostMapping(path="/template", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createTemplate(@RequestBody TemplateEntity newTemplate){
		deanService.createTemplate(newTemplate);
	}

}
