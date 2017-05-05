package iit.me.service;

import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;

@Service
public interface DeanService {
	
	Iterable<RequestEntity> listRequests();
	void makeVerdict(long requestId);
	//void addTemplate(TemplateEntity newTemplate);

}
